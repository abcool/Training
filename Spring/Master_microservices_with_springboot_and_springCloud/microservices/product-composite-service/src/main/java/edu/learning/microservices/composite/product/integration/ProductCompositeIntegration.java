package edu.learning.microservices.composite.product.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.learning.api.core.product.IProduct;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.core.recommendation.IRecommendation;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.core.review.IReview;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.microservices.composite.product.client.ProductServiceClient;
import edu.learning.microservices.composite.product.client.RecommendationServiceClient;
import edu.learning.microservices.composite.product.client.ReviewServiceClient;
import edu.learning.util.http.HttpErrorInfo;
import feign.FeignException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

@Component
public class ProductCompositeIntegration implements IProduct, IRecommendation, IReview {
    private static final Logger log = LogManager.getLogger(ProductCompositeIntegration.class);
    private final ProductServiceClient productClient;
    private final RecommendationServiceClient recommendationClient;
    private final ReviewServiceClient reviewClient;
    private final ObjectMapper mapper;

    @Autowired
    public ProductCompositeIntegration(ProductServiceClient productClient, ObjectMapper mapper,
                                       RecommendationServiceClient recommendationClient,
                                       ReviewServiceClient reviewClient) {
        this.productClient = productClient;
        this.mapper = mapper;
        this.recommendationClient = recommendationClient;
        this.reviewClient = reviewClient;
    }

    @Override
    public Mono<ResponseEntity<ProductDTO>> getProduct(Integer productId) {
        log.debug("Calling product-service to get product details");
        return productClient.getProduct(productId)
                .doOnNext(product -> log.info("Product details received: {}", product))
                .map(ResponseEntity::ok)
                .onErrorResume(FeignException.class, this::handleFeignException);
    }

    @Override
    public Mono<ResponseEntity<List<RecommendationDTO>>> getRecommendations(int productId) {
        log.info("Calling recommendation-service to fetch recommendations for product: {}", productId);
        return recommendationClient.getRecommendations(productId)
                .doOnNext(recommendations -> log.debug("Recommendations received for product: {} are {}", productId, recommendations))
                .map(ResponseEntity::ok)
                .onErrorResume(FeignException.class, this::handleFeignException);
    }

    @Override
    public Mono<ResponseEntity<List<ReviewDTO>>> getReviews(int productId) {
        log.info("Calling review service to fetch review for product: {}", productId);
        return reviewClient.getReviews(productId)
                .doOnNext(reviews -> log.debug("Reviews received for product: {} are {}", productId, reviews))
                .map(ResponseEntity::ok)
                .onErrorResume(FeignException.class, this::handleFeignException);
    }

    private <T> Mono<T> handleFeignException(FeignException e) {
        HttpStatus status = HttpStatus.resolve(e.status());
        if (status == null) {
            log.error("Unknown HTTP status code: {}", e.status());
            return Mono.error(e);
        }

        return switch (status) {
            case NOT_FOUND -> Mono.error(new NotFoundException(getErrorMessage(e)));
            case UNPROCESSABLE_ENTITY -> Mono.error(new InvalidInputException(getErrorMessage(e)));
            default -> {
                log.error("Unexpected error occurred: {}", e.getMessage());
                yield Mono.error(e);
            }
        };
    }

    private String getErrorMessage(FeignException ex) {
        String content = ex.contentUTF8();
        if (content == null || content.isBlank()) {
            return ex.getMessage() != null ? ex.getMessage() : "Unknown error";
        }

        try {
            HttpErrorInfo errorInfo = mapper.readValue(content, HttpErrorInfo.class);
            String msg = errorInfo.getMessage();
            return (msg != null && !msg.isBlank()) ? msg : (ex.getMessage() != null ? ex.getMessage() : content);
        } catch (IOException ioex) {
            return !content.isBlank() ? content : (ex.getMessage() != null ? ex.getMessage() : "Unknown error");
        }
    }
}