package edu.learning.api.core.recommendation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import reactor.core.publisher.Mono; // Added for reactive types

public interface IRecommendation {

    @GetMapping(
            value = "/recommendation",
            produces = "application/json")
    Mono<ResponseEntity<List<RecommendationDTO>>> getRecommendations( // Changed to Mono
                                                                      @RequestParam(name = "productId", required = true) int productId);
    @PostMapping(value = "/recommendation",
                 consumes = "application/json",
                 produces = "application/json")
    Mono<ResponseEntity<RecommendationDTO>> createRecommendation(@RequestBody RecommendationDTO body);

    @DeleteMapping(value = "/recommendation")
    Mono<ResponseEntity<Void>> deleteRecommendations(@RequestParam(name = "productId", required = true) int productId);
}