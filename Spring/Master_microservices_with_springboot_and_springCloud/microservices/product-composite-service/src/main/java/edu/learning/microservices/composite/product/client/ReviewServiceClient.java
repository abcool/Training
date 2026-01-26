package edu.learning.microservices.composite.product.client;

import edu.learning.api.core.review.ReviewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

import java.util.List;

@ReactiveFeignClient(url = "${review-service-url}", name="review-service")
public interface ReviewServiceClient {

    @PostMapping(value = "/review", consumes = "application/json",
            produces = "application/json")
    Mono<ReviewDTO> createReview(@RequestBody ReviewDTO body);

    @GetMapping(value = "/review", produces = "application/json")
    Mono<List<ReviewDTO>> getReviews(@RequestParam(name = "productId", required = true) int productId);

    @DeleteMapping(value = "/review")
    Mono<Void> deleteReviews(@RequestParam(name = "productId", required = true) int productId);

}