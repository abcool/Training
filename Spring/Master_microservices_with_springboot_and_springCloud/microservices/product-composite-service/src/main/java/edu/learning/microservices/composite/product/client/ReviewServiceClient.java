package edu.learning.microservices.composite.product.client;

import edu.learning.api.core.review.ReviewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

import java.util.List;

@ReactiveFeignClient(url = "${review-service-url}", name="review-service-client")
public interface ReviewServiceClient {

    @GetMapping(path = "/review")
    Mono<List<ReviewDTO>> getReviews(@RequestParam(name = "productId") int productId);

}