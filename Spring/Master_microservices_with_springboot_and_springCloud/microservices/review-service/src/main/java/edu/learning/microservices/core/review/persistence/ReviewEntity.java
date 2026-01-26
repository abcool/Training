package edu.learning.microservices.core.review.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "reviews")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewEntity {

    @Id
    private Integer id;  // Use Integer for nullable auto-generated IDs

    @Version
    private Integer version;

    @Column("product_id")
    private int productId;

    @Column("review_id")
    private int reviewId;

    private String author;
    private String subject;
    private String content;
}