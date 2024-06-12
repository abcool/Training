package edu.learning.api.composite;

import java.util.List;

public class ProductAggregateDTO {
    private final int productId;
    private final String name;
    private final int weight;
    private final List<RecommendationSummaryDTO> recommendations;
    private final List<ReviewSummaryDTO> reviews;
    private final ServiceAddressDTO serviceAddresses;

    public ProductAggregateDTO(int productId, String name, int weight, List<RecommendationSummaryDTO> recommendations, List<ReviewSummaryDTO> reviews, ServiceAddressDTO serviceAddresses) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
        this.recommendations = recommendations;
        this.reviews = reviews;
        this.serviceAddresses = serviceAddresses;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public List<RecommendationSummaryDTO> getRecommendations() {
        return recommendations;
    }

    public List<ReviewSummaryDTO> getReviews() {
        return reviews;
    }

    public ServiceAddressDTO getServiceAddresses() {
        return serviceAddresses;
    }
}
