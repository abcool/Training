package edu.learning.api.core.product;


public class ProductDTO {
    private final int productId;
    private final String name;
    private final int weight;
    private final String serviceAddress;

    public ProductDTO() {
        productId = 0;
        name="";
        weight = 0;
        serviceAddress="";
    }

    public ProductDTO(int productId, String name, int weight, String serviceAddress) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
        this.serviceAddress = serviceAddress;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }
}
