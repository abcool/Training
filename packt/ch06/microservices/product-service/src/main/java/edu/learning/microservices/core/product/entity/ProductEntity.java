package edu.learning.microservices.core.product.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class ProductEntity {

    @Id
    private String id;
    @Version
    private Integer version;

    @Indexed(unique = true)
    private Integer productId;
    private String name;
    private Integer weight;

    public ProductEntity() {
    }

    public ProductEntity(Integer productId, String name, Integer weight) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
