package edu.learning.microservices.core.product.persistence;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Getter
@Setter
@ToString
public class ProductEntity {

    @Id
    private String id;  // MongoDB's _id field

    @Indexed(unique = true)
    private int productId;  // Your business ID with unique index

    @Version
    private Integer version;

    private String name;
    private int weight;

    public ProductEntity() {}

    public ProductEntity(int productId, String name, int weight) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
    }
}
