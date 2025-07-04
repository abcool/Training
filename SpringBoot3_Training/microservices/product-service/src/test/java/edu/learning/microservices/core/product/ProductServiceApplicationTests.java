package edu.learning.microservices.core.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
    private final int PRODUCT_ID_OK=1;
    private final int PRODUCT_ID_NOT_FOUND=13;
    private final int PRODUCT_ID_INVALID=-1;

    @Autowired
    private WebTestClient testClient;

    @Test
    public void getProductById() {
        testClient.get()
                .uri("/product/" + PRODUCT_ID_OK)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.productId").isEqualTo(PRODUCT_ID_OK)
                .jsonPath("$.name").isEqualTo("name-")
                .jsonPath("$.weight").isEqualTo(123)
                .jsonPath("$.serviceAddress").isNotEmpty();
    }

    @Test
    public void getProductNotFound() {
        testClient.get()
                .uri("/product/" + PRODUCT_ID_NOT_FOUND)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("$.path").isEqualTo("/product/" + PRODUCT_ID_NOT_FOUND)
                .jsonPath("$.message").isEqualTo("No product found for productId: " + PRODUCT_ID_NOT_FOUND);
    }

    @Test
    public void getProductInvalidInput() {
        testClient.get()
                .uri("/product/" + PRODUCT_ID_INVALID)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY)
                .expectBody()
                .jsonPath("$.path").isEqualTo("/product/" + PRODUCT_ID_INVALID)
                .jsonPath("$.message").isEqualTo("Invalid productId: " + PRODUCT_ID_INVALID);
    }

    @Test
    public void getProductInvalidParameterString(){
        testClient.get()
                .uri("/product/no-integer")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST)
                .expectBody()
                .jsonPath("$.path").isEqualTo("/product/no-integer")
                .jsonPath("$.message").isEqualTo("400 BAD_REQUEST \"Type mismatch.\"");
    }

}
