package edu.learning.record;

import java.math.BigDecimal;
import java.util.Objects;

public record Product(String name, BigDecimal cost, String type) {
    public Product {
        if(name!=null && name.isBlank()){
            throw new IllegalArgumentException("name is blank");
        }
        if(cost.compareTo(BigDecimal.ZERO)<=0){
            throw new IllegalArgumentException("Cost should be greater than zero.");
        }
    }
    public Product(String name){
        this(name,BigDecimal.ONE,"DEFAULT");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Objects.equals(name, product.name) && Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    public static void main(String[] args) {
        Product product = new Product("Iphone",new BigDecimal("999.98"),"Electronics");
        System.out.println(product);
//        Product product2 = new Product("",new BigDecimal("999.98"),"Electronics");
//        System.out.println(product2);
        Product product1 = new Product("Watch");
        System.out.println(product1);
        Product product2 = new Product("Watch",BigDecimal.ONE,"DEFAULT");
        System.out.println("product1==product2: "+product1.equals(product2));
    }
}
