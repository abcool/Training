package edu.learning.api.core.recommendation;
public record RecommendationDTO(int productId, int recommendationId, String author, int rate, String content, String serviceAddress) {}