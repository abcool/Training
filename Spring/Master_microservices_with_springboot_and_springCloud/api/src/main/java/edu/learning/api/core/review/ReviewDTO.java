package edu.learning.api.core.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ReviewDTO {
    private final int productId;
    private final int reviewId;
    private final String author;
    private final String subject;
    private final String content;
    private final String serviceAddress;

    @SuppressWarnings("unused")
    public ReviewDTO(){
        this.productId=0;
        this.reviewId=0;
        this.author="";
        this.subject="";
        this.content="";
        this.serviceAddress="";
    }
}
