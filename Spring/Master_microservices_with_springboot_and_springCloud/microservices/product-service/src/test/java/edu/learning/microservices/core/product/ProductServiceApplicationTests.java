package edu.learning.microservices.core.product;

import edu.learning.api.core.product.ProductDTO;
import edu.learning.microservices.core.product.config.MongoTestConfig;
import edu.learning.microservices.core.product.persistence.ProductRepository;
import edu.learning.util.http.ServiceUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.*;
import static org.springframework.http.HttpStatus.*;

import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Import(MongoTestConfig.class)
class ProductServiceApplicationTests {

	@Autowired private WebTestClient client;
	@Autowired private ProductRepository repository;

	@MockitoBean
	private ServiceUtil serviceUtil;

	@BeforeEach
	void setupDb() {
		when(serviceUtil.getServiceAddress()).thenReturn("test-address");
		repository.deleteAll().block();
	}

	@Test
	void getProductById() {
		int productId = 1;

		// Create product
		postAndVerifyProduct(productId, CREATED)
				.jsonPath("$.productId").isEqualTo(productId);

		// Now GET should work
		getAndVerifyProduct(productId, OK)
				.jsonPath("$.productId").isEqualTo(productId);
	}

	@Test
	void duplicateError() {
		int productId = 1;
		postAndVerifyProduct(productId, CREATED);

		// Print the actual response body
		byte[] responseBody = client.post()
				.uri("/product")
				.body(Mono.just(new ProductDTO(productId, "Name " + productId, productId, "SA")), ProductDTO.class)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY)
				.expectBody()
				.returnResult()
				.getResponseBody();

		System.out.println("Actual error response: " + new String(responseBody));

		// Then run normal assertions
		postAndVerifyProduct(productId, HttpStatus.UNPROCESSABLE_ENTITY)
				.jsonPath("$.path").isEqualTo("/product")
				.jsonPath("$.message").isEqualTo("Duplicate key, Product Id: " + productId);
	}



	@Test
	void deleteProduct() {
		int productId = 1;
		postAndVerifyProduct(productId, CREATED);

		deleteAndVerifyProduct(productId, NO_CONTENT);
		assertFalse(repository.findByProductId(productId).blockOptional().isPresent());

		deleteAndVerifyProduct(productId, NOT_FOUND);
	}

	@Test
	void getProductInvalidParameterString() {
		getAndVerifyProduct("/no-integer", BAD_REQUEST)
				.jsonPath("$.path").isEqualTo("/product/no-integer")
				.jsonPath("$.message").isEqualTo("Type mismatch.");
	}

	@Test
	void getProductNotFound() {
		int productIdNotFound = 13;
		getAndVerifyProduct(productIdNotFound, NOT_FOUND)
				.jsonPath("$.path").isEqualTo("/product/" + productIdNotFound)
				.jsonPath("$.message").isEqualTo("No product found for productId: " + productIdNotFound);
	}

	@Test
	void getProductInvalidParameterNegativeValue() {
		int productIdInvalid = -1;
		getAndVerifyProduct(productIdInvalid, UNPROCESSABLE_ENTITY)
				.jsonPath("$.path").isEqualTo("/product/" + productIdInvalid)
				.jsonPath("$.message").isEqualTo("Invalid productId: " + productIdInvalid);
	}

	private WebTestClient.BodyContentSpec getAndVerifyProduct(int productId, HttpStatus expectedStatus) {
		return getAndVerifyProduct("/" + productId, expectedStatus);
	}

	private WebTestClient.BodyContentSpec getAndVerifyProduct(String productIdPath, HttpStatus expectedStatus) {
		return client.get()
				.uri("/product" + productIdPath)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec postAndVerifyProduct(int productId, HttpStatus expectedStatus) {
		ProductDTO product = new ProductDTO(productId, "Name " + productId, productId, "SA");
		return client.post()
				.uri("/product")
				.body(Mono.just(product), ProductDTO.class)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec deleteAndVerifyProduct(int productId, HttpStatus expectedStatus) {
		return client.delete()
				.uri("/product/" + productId)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectBody();
	}
}
