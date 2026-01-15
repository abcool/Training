package edu.learning.api.core.recommendation;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class RecommendationDTO {
    private int productId;
    private int recommendationId;
    private String author;
    private int rate;
    private String content;
    private String serviceAddress;
}
