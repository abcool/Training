package edu.learning.microservices.core.product;


import edu.learning.api.core.product.ProductDTO;
import edu.learning.microservices.core.product.persistence.ProductRepository;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.http.HttpStatus.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
    private final int PRODUCT_ID_OK=1;
    private final int PRODUCT_ID_NOT_FOUND=13;
    private final int PRODUCT_ID_INVALID=-1;

    @Autowired
    private WebTestClient testClient;

    @Autowired private ProductRepository repository;

    @BeforeEach
    void setupDb() {
        repository.deleteAll();
    }
    @Test
    void getProductById() {

        postAndVerifyProduct(PRODUCT_ID_OK, OK);

        assertTrue(repository.findByProductId(PRODUCT_ID_OK).isPresent());

        getAndVerifyProduct(PRODUCT_ID_OK, OK).jsonPath("$.productId").isEqualTo(PRODUCT_ID_OK);
    }

    @Test
    void duplicateError() {

        postAndVerifyProduct(PRODUCT_ID_OK, OK);

        assertTrue(repository.findByProductId(PRODUCT_ID_OK).isPresent());

        postAndVerifyProduct(PRODUCT_ID_OK, UNPROCESSABLE_ENTITY)
                .jsonPath("$.path").isEqualTo("/product")
                .jsonPath("$.message").isEqualTo("Duplicate key, Product Id: " + PRODUCT_ID_OK);
    }

    @Test
    void deleteProduct() {

        postAndVerifyProduct(PRODUCT_ID_OK, OK);
        assertTrue(repository.findByProductId(PRODUCT_ID_OK).isPresent());

        deleteAndVerifyProduct(PRODUCT_ID_OK, OK);
        assertFalse(repository.findByProductId(PRODUCT_ID_OK).isPresent());

        deleteAndVerifyProduct(PRODUCT_ID_OK, OK);
    }

    @Test
    void getProductNotFound() {


        getAndVerifyProduct(PRODUCT_ID_NOT_FOUND, NOT_FOUND)
                .jsonPath("$.path").isEqualTo("/product/" + PRODUCT_ID_NOT_FOUND)
                .jsonPath("$.message").isEqualTo("No product found for productId: " + PRODUCT_ID_NOT_FOUND);
    }

    @Test
    void getProductInvalidInput() {

        getAndVerifyProduct(PRODUCT_ID_INVALID, UNPROCESSABLE_ENTITY)
                .jsonPath("$.path").isEqualTo("/product/" + PRODUCT_ID_INVALID)
                .jsonPath("$.message").isEqualTo("Invalid productId: " + PRODUCT_ID_INVALID);
    }

    @Test
    void getProductInvalidParameterString() {

        getAndVerifyProduct("/no-integer", BAD_REQUEST)
                .jsonPath("$.path").isEqualTo("/product/no-integer")
                .jsonPath("$.message").isEqualTo("Type mismatch. expected integer value");
    }

    private WebTestClient.BodyContentSpec getAndVerifyProduct(int productId, HttpStatus expectedStatus) {
        return getAndVerifyProduct("/" + productId, expectedStatus);
    }

    private WebTestClient.BodyContentSpec getAndVerifyProduct(String productIdPath, HttpStatus expectedStatus) {
        return testClient.get()
                .uri("/product" + productIdPath)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isEqualTo(expectedStatus)
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody();
    }

    private WebTestClient.BodyContentSpec postAndVerifyProduct(int productId, HttpStatus expectedStatus) {
        ProductDTO product = new ProductDTO(productId, "Name " + productId, productId, "SA");
        return testClient.post()
                .uri("/product")
                .body(Mono.just(product), ProductDTO.class)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isEqualTo(expectedStatus)
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody();
    }
    private WebTestClient.BodyContentSpec deleteAndVerifyProduct(int productId, HttpStatus expectedStatus) {
        return testClient.delete()
                .uri("/product/" + productId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isEqualTo(expectedStatus)
                .expectBody();
    }
}