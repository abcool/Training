package edu.learning.api.core.product;

public record Product(int productId, String name, int weight, String serviceAddress){
    public Product(){this(0,"",0,"");};
};