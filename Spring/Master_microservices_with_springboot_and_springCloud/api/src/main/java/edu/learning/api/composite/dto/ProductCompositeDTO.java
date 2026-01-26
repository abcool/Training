package edu.learning.api.composite.dto;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
@Setter
@NoArgsConstructor
public class ProductCompositeDTO {
    private int productId;
    private String name;
    private int weight;
    private List<RecommendationSummaryDTO> recommendations;
    private List<ReviewSummaryDTO> reviews;
    private ServiceAddressesDTO serviceAddresses;
}
