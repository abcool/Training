package edu.learning.microservices.composite.product.client;

import edu.learning.api.core.recommendation.RecommendationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

import java.util.List;

@ReactiveFeignClient(url="${recommendation-service-url}", name="recommendation-service")
public interface RecommendationServiceClient {

    @GetMapping(
            value = "/recommendation",
            produces = "application/json")
    Mono<List<RecommendationDTO>> getRecommendations(@RequestParam(name = "productId", required = true) int productId);

    @PostMapping(value = "/recommendation",
            consumes = "application/json",
            produces = "application/json")
    Mono<RecommendationDTO> createRecommendation(@RequestBody RecommendationDTO body);

    @DeleteMapping(value = "/recommendation")
    Mono<Void> deleteRecommendations(@RequestParam(name = "productId", required = true) int productId);
}