package edu.learning.api.core.recommendation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class RecommendationDTO {
    private final int productId;
    private final int recommendationId;
    private final String author;
    private final int rate;
    private final String content;
    private final String serviceAddress;

    @SuppressWarnings("unused")
    public RecommendationDTO(){
        this.productId=0;
        this.recommendationId=0;
        this.author="";
        this.rate=0;
        this.content="";
        this.serviceAddress="";
    }
}
