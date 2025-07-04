package edu.learning.microservices.composite.product;


import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductCompositeServiceApplicationTests {
    private static final int PRODUCT_ID_OK = 1;
    private static final int PRODUCT_ID_NOT_FOUND = 2;
    private static final int PRODUCT_ID_INVALID = 3;

    @Autowired
    private WebTestClient testClient;
    @MockitoBean
    private ProductCompositeHelper helper;
    @BeforeEach
    public void setup(){
        Mockito.when(helper.getProduct(PRODUCT_ID_OK))
                .thenReturn(new ProductDTO(PRODUCT_ID_OK,"name",1, "mock-address"));
        Mockito.when(helper.getRecommendations(PRODUCT_ID_OK))
                .thenReturn(Collections.singletonList(
                        new RecommendationDTO(PRODUCT_ID_OK,1,"author",1,"content","mock-address")
                ));
        Mockito.when(helper.getReviews(PRODUCT_ID_OK))
                .thenReturn(Collections.singletonList(
                        new ReviewDTO(PRODUCT_ID_OK,1,"author","subject","content","mock-address")
                ));
        Mockito.when(helper.getProduct(PRODUCT_ID_NOT_FOUND))
                .thenThrow(new NotFoundException(PRODUCT_ID_NOT_FOUND +" not found"));
        Mockito.when(helper.getProduct(PRODUCT_ID_INVALID))
                .thenThrow(new InvalidInputException("Invalid productId: " + PRODUCT_ID_INVALID));
    }
    @Test
    public void getProductById(){
        testClient.get()
                .uri("/product-composite/" + PRODUCT_ID_OK)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.productId").isEqualTo(PRODUCT_ID_OK)
                .jsonPath("$.recommendations.length()").isEqualTo(1)
                .jsonPath("$.reviews.length()").isEqualTo(1);
    }

    @Test
    public void getProductNotFound(){
        testClient.get()
                .uri("/product-composite/" + PRODUCT_ID_NOT_FOUND)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("$.message").isEqualTo(PRODUCT_ID_NOT_FOUND + " not found");
    }
    @Test
    public void getProductInvalidInput(){
        testClient.get()
                .uri("/product-composite/" + PRODUCT_ID_INVALID)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY)
                .expectBody()
                .jsonPath("$.message").isEqualTo("Invalid productId: " + PRODUCT_ID_INVALID);
    }
}
