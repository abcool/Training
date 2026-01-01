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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
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

    private ProductCompositeDTO createCompositeProduct(ProductDTO product, List<RecommendationDTO> recommendations, List<ReviewDTO> reviews, String serviceAddress) {
        var recommendationSummaryDTO = recommendations.stream().
                map(recommendation ->
                        new RecommendationSummaryDTO(
                                recommendation.getRecommendationId(),
                                recommendation.getAuthor(),
                                recommendation.getRate()))
                .toList();
        var reviewSummaryDTO = reviews.stream()
                .map(review -> new ReviewSummaryDTO(
                        review.getReviewId(),
                        review.getAuthor(),
                        review.getSubject()
                ))
                .toList();
        var productAddress = product.getServiceAddress();
        var reviewAddress = reviews.isEmpty() ? "" : reviews.get(0).getServiceAddress();
        var recommendationAddress = recommendations.isEmpty() ? "" : recommendations.get(0).getServiceAddress();
        var compositeServiceAddress = new ServiceAddressesDTO(serviceAddress, productAddress,reviewAddress,recommendationAddress);
        return new ProductCompositeDTO(product.getProductId(),product.getName(),product.getWeight(),recommendationSummaryDTO, reviewSummaryDTO,compositeServiceAddress);
    }
}