package edu.learning.api.core.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import reactor.core.publisher.Mono; // Added for reactive types
@RequestMapping("/review")
public interface IReview {

    @PostMapping(consumes = "application/json",
                 produces = "application/json")
    Mono<ResponseEntity<ReviewDTO>> createReview(@RequestBody ReviewDTO body);

    @GetMapping(produces = "application/json")
    @SuppressWarnings("unused")
    Mono<ResponseEntity<List<ReviewDTO>>> getReviews(@RequestParam(name = "productId", required = true) int productId);

    @DeleteMapping
    Mono<ResponseEntity<Void>> deleteReviews(@RequestParam(name = "productId", required = true) int productId);
}