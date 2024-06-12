package edu.learning.api.composite;

public class RecommendationSummaryDTO {

    private final int recommendationId;
    private final String author;
    private final int rate;

    public RecommendationSummaryDTO(int recommendationId, String author, int rate) {
        this.recommendationId = recommendationId;
        this.author = author;
        this.rate = rate;
    }

    public int getRecommendationId() {
        return recommendationId;
    }

    public String getAuthor() {
        return author;
    }

    public int getRate() {
        return rate;
    }
}
