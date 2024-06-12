package edu.learning.api.core.recommendation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IRecommendation {
    @GetMapping(value = "/recommendation", produces = "application/json")
    List<RecommendationDTO> getRecommendations(@RequestParam(value = "productId", required = true) int productId);
}
