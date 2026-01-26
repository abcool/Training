package edu.learning.api.core.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO{

    private int productId;
    private String name;
    private int weight;
    private String serviceAddress;

    @SuppressWarnings("unused")
    public ProductDTO(){
        this.productId = 0;
        this.name="";
        this.weight=0;
        this.serviceAddress="";
    }
}