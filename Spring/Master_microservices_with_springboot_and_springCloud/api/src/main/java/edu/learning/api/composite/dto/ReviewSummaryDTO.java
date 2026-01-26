package edu.learning.api.composite.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@NoArgsConstructor
public class ReviewSummaryDTO {

    private int reviewId;
    private String author;
    private String subject;
    private String content;
}
