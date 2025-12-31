package edu.learning.api.core.recommendation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import reactor.core.publisher.Mono; // Added for reactive types

public interface IRecommendation {

    @GetMapping(
            value = "/recommendation",
            produces = "application/json")
    Mono<ResponseEntity<List<RecommendationDTO>>> getRecommendations( // Changed to Mono
                                                                      @RequestParam(name = "productId", required = true) int productId);

}