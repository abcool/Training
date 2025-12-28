package edu.learning.api.composite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReviewSummaryDTO {

    private final int reviewId;
    private final String author;
    private final String subject;
}
