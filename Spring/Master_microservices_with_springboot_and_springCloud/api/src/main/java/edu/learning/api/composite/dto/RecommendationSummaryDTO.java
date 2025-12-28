package edu.learning.api.composite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RecommendationSummaryDTO {
    private final int recommendationId;
    private final String author;
    private final int rate;
}
