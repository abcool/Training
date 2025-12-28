package edu.learning.microservices.composite.product;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.microservices.composite.product.integration.ProductCompositeIntegration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ProductCompositeServiceApplicationTests {

    private static final int PRODUCT_ID_OK = 1;
    private static final int PRODUCT_ID_NOT_FOUND = 2;
    private static final int PRODUCT_ID_INVALID = 3;

    @Autowired private WebTestClient client;
    @MockitoBean
    private ProductCompositeIntegration compositeIntegration;

    @BeforeEach
    void setUp() {
        when(compositeIntegration.getProduct(PRODUCT_ID_OK))
                .thenReturn(ResponseEntity.ok(new ProductDTO(PRODUCT_ID_OK, "name", 1, "mock-address")));
        when(compositeIntegration.getRecommendations(PRODUCT_ID_OK))
                .thenReturn(ResponseEntity.ok(singletonList(
                        new RecommendationDTO(PRODUCT_ID_OK, 1, "author", 1, "content", "mock address")
                )));
        when(compositeIntegration.getReviews(PRODUCT_ID_OK))
                .thenReturn(ResponseEntity.ok(singletonList(
                        new ReviewDTO(PRODUCT_ID_OK, 1, "author", "subject", "content", "mock address")
                )));

        when(compositeIntegration.getProduct(PRODUCT_ID_NOT_FOUND))
                .thenThrow(new NotFoundException("NOT FOUND: " + PRODUCT_ID_NOT_FOUND));

        when(compositeIntegration.getProduct(PRODUCT_ID_INVALID))
                .thenThrow(new InvalidInputException("INVALID: " + PRODUCT_ID_INVALID));
    }

    @Test
    void getProductById() {
        client.get()
                .uri("/product-composite/" + PRODUCT_ID_OK)
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.productId").isEqualTo(PRODUCT_ID_OK)
                .jsonPath("$.recommendations.length()").isEqualTo(1)
                .jsonPath("$.reviews.length()").isEqualTo(1);
    }

    @Test
    void getProductNotFound() {
        client.get()
                .uri("/product-composite/" + PRODUCT_ID_NOT_FOUND)
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound()
                .expectHeader().contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.path").isEqualTo("/product-composite/" + PRODUCT_ID_NOT_FOUND);
    }

    @Test
    void getProductInvalidInput() {
        client.get()
                .uri("/product-composite/" + PRODUCT_ID_INVALID)
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isEqualTo(UNPROCESSABLE_ENTITY)
                .expectHeader().contentType(APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.path").isEqualTo("/product-composite/" + PRODUCT_ID_INVALID);
    }
}