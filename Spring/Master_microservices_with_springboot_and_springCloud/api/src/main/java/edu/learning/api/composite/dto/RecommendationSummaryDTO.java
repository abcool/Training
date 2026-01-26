package edu.learning.api.composite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class RecommendationSummaryDTO {
    private int recommendationId;
    private String author;
    private int rate;
    private String content;
}
