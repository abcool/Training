package edu.learning.microservices.composite.product.service;

import edu.learning.api.composite.IProductComposite;
import edu.learning.api.composite.dto.ProductCompositeDTO;
import edu.learning.api.composite.dto.RecommendationSummaryDTO;
import edu.learning.api.composite.dto.ReviewSummaryDTO;
import edu.learning.api.composite.dto.ServiceAddressesDTO;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.microservices.composite.product.integration.ProductCompositeIntegration;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ProductCompositeService implements IProductComposite {
    private static final Logger log = LogManager.getLogger(ProductCompositeService.class);
    private final ProductCompositeIntegration integration;
    private final ServiceUtil serviceUtil;

    @Autowired
    public ProductCompositeService(ProductCompositeIntegration integration, ServiceUtil serviceUtil) {
        this.integration = integration;
        this.serviceUtil = serviceUtil;
    }

    /**
     * @param productCompositeDTO A JSON representation of the new composite product
     * @return
     */
    @Override
    public Mono<ResponseEntity<ProductCompositeDTO>> createProduct(ProductCompositeDTO productCompositeDTO) {
        log.info("createProduct: Received a request to create a composite product: {}", productCompositeDTO);

        var productDTO = new ProductDTO(
                productCompositeDTO.getProductId(),
                productCompositeDTO.getName(),
                productCompositeDTO.getWeight(),
                serviceUtil.getServiceAddress());

        Mono<ProductDTO> productDTOMono = integration.createProduct(productDTO).map(ResponseEntity::getBody);

        Mono<List<RecommendationDTO>> recommendationDTOMono = Flux.fromIterable(productCompositeDTO.getRecommendations())
                .flatMap(r -> {
                    var recommendationDTO = new RecommendationDTO(
                            productCompositeDTO.getProductId(),
                            r.getRecommendationId(),
                            r.getAuthor(),
                            r.getRate(),
                            r.getContent(),
                            serviceUtil.getServiceAddress());
                    return integration.createRecommendation(recommendationDTO);
                })
                .map(ResponseEntity::getBody)
                .collectList();

        Mono<List<ReviewDTO>> reviewDTOMono = Flux.fromIterable(productCompositeDTO.getReviews())
                .flatMap(r -> {
                    var reviewDTO = new ReviewDTO(
                            productCompositeDTO.getProductId(),
                            r.getReviewId(),
                            r.getAuthor(),
                            r.getSubject(),
                            r.getContent(),
                            serviceUtil.getServiceAddress());
                    return integration.createReview(reviewDTO);
                })
                .map(ResponseEntity::getBody)
                .collectList();

        return productDTOMono
                .flatMap(product -> recommendationDTOMono
                        .flatMap(recommendations -> reviewDTOMono
                                .map(reviews -> {
                                    var compositeProduct = createCompositeProduct(product, recommendations, reviews, serviceUtil.getServiceAddress());
                                    return new ResponseEntity<>(compositeProduct, HttpStatus.CREATED);
                                })
                        )
                );
    }

    /**
     * @param productId
     * @return
     */
    @Override
    public Mono<ResponseEntity<ProductCompositeDTO>> getCompositeProduct(int productId) {
        log.info("Fetching details for product: {}", productId);

        return integration.getProduct(productId)
                .flatMap(productResponse -> {
                    ProductDTO product = productResponse.getBody();
                    if (product == null) {
                        return Mono.error(new NotFoundException("No product found for productId: " + productId));
                    }

                    // Execute recommendations and reviews in parallel
                    Mono<List<RecommendationDTO>> recommendationsMono = integration.getRecommendations(productId)
                            .map(ResponseEntity::getBody)
                            .defaultIfEmpty(List.of());

                    Mono<List<ReviewDTO>> reviewsMono = integration.getReviews(productId)
                            .map(ResponseEntity::getBody)
                            .defaultIfEmpty(List.of());

                    // Combine results using Mono.zip for parallel execution
                    return Mono.zip(recommendationsMono, reviewsMono)
                            .map(tuple -> {
                                List<RecommendationDTO> recommendations = tuple.getT1();
                                List<ReviewDTO> reviews = tuple.getT2();
                                return createCompositeProduct(
                                        product,
                                        recommendations,
                                        reviews,
                                        serviceUtil.getServiceAddress()
                                );
                            });
                })
                .map(ResponseEntity::ok);
    }

    /**
     * @param productId Id of the product
     * @return
     */
    @Override
    public Mono<ResponseEntity<Void>> deleteProduct(int productId) {
        log.info("Deleting product with id {}", productId);

        return Mono.zip(
                        integration.deleteProduct(productId),
                        integration.deleteRecommendations(productId),
                        integration.deleteReviews(productId)
                )
                .doOnNext(v -> log.info("Deleted product, recommendations, and reviews for product id {}", productId))
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
    }

    private ProductCompositeDTO createCompositeProduct(ProductDTO product, List<RecommendationDTO> recommendations, List<ReviewDTO> reviews, String serviceAddress) {
        var recommendationSummaryDTO = recommendations.stream().
                map(recommendation ->
                        new RecommendationSummaryDTO(
                                recommendation.getRecommendationId(),
                                recommendation.getAuthor(),
                                recommendation.getRate(),
                                recommendation.getContent()))
                .toList();
        var reviewSummaryDTO = reviews.stream()
                .map(review -> new ReviewSummaryDTO(
                        review.getReviewId(),
                        review.getAuthor(),
                        review.getSubject(),
                        review.getContent()
                ))
                .toList();
        var productAddress = product.getServiceAddress();
        var reviewAddress = reviews.isEmpty() ? "" : reviews.get(0).getServiceAddress();
        var recommendationAddress = recommendations.isEmpty() ? "" : recommendations.get(0).getServiceAddress();
        var compositeServiceAddress = new ServiceAddressesDTO(serviceAddress, productAddress,reviewAddress,recommendationAddress);
        return new ProductCompositeDTO(product.getProductId(),product.getName(),product.getWeight(),recommendationSummaryDTO, reviewSummaryDTO,compositeServiceAddress);
    }
}