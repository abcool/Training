package edu.learning.api.core.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import reactor.core.publisher.Mono; // Added for reactive types

public interface IReview {

    @GetMapping(
            value = "/review",
            produces = "application/json")
    @SuppressWarnings("unused")
    Mono<ResponseEntity<List<ReviewDTO>>> getReviews(@RequestParam(name = "productId", required = true) int productId); // Changed to Mono
}