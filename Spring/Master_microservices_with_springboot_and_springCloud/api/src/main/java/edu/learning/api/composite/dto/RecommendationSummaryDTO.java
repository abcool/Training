package edu.learning.api.composite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class RecommendationSummaryDTO {
    private final int recommendationId;
    private final String author;
    private final int rate;
}
