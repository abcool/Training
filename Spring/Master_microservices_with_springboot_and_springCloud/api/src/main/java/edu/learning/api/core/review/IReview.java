package edu.learning.api.core.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IReview {

    @GetMapping(
            value = "/review",
            produces = "application/json")
    @SuppressWarnings("unused")
    ResponseEntity<List<ReviewDTO>> getReviews(@RequestParam(name = "productId", required = true) int productId);
}
