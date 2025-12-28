package edu.learning.api.core.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDTO{
    private final int productId;
    private final String name;
    private final int weight;
    private final String serviceAddress;

    @SuppressWarnings("unused")
    public ProductDTO(){
        this.productId = 0;
        this.name="";
        this.weight=0;
        this.serviceAddress="";
    }
}