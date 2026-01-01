package edu.learning.api.composite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class ProductCompositeDTO {
    private final int productId;
    private final String name;
    private final int weight;
    private final List<RecommendationSummaryDTO> recommendations;
    private final List<ReviewSummaryDTO> reviews;
    private final ServiceAddressesDTO serviceAddresses;
}
