package edu.learning.microservices.composite.product.client;

import edu.learning.api.core.recommendation.RecommendationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

import java.util.List;

@ReactiveFeignClient(url="${recommendation-service-url}", name="recommendation-service-client")
public interface RecommendationServiceClient {

    @GetMapping(path = "/recommendation")
    Mono<ResponseEntity<List<RecommendationDTO>>> getRecommendations(@RequestParam(name = "productId") int productId);
}