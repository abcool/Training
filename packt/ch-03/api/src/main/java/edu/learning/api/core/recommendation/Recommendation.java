package edu.learning.api.core.recommendation;
public record Recommendation(int productId, int recommendatiionId, String author, int rate, String content, String serviceAddress){
    public Recommendation(){this(0,0,"",0,"","");}
};