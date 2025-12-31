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
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

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
        ProductDTO product = integration.getProduct(productId).block().getBody();
        if(Objects.isNull(product)) throw new NotFoundException("No product found for productId: " + productId);
        var recommendations = integration.getRecommendations(productId).block().getBody();
        var reviews = integration.getReviews(productId).block().getBody();
        return Mono.just(new ResponseEntity<>(createCompositeProduct(product,recommendations,reviews, serviceUtil.getServiceAddress()), HttpStatus.OK));
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
        var reviewAddress = reviews.size()>0?reviews.get(0).getServiceAddress():"";
        var recommendationAddress = recommendations.size()>0?recommendations.get(0).getServiceAddress():"";
        var compositeServiceAddress = new ServiceAddressesDTO(serviceAddress, productAddress,reviewAddress,recommendationAddress);
        return new ProductCompositeDTO(product.getProductId(),product.getName(),product.getWeight(),recommendationSummaryDTO, reviewSummaryDTO,compositeServiceAddress);
    }
}
