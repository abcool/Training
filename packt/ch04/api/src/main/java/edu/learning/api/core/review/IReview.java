package edu.learning.api.core.review;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IReview {

    @GetMapping(value = "/review", produces = "application/json")
    List<ReviewDTO> getReviews(@RequestParam(value = "productId", required = true) int productId);
}