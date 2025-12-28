package edu.learning.microservices.core.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.http.MediaType.*;

import static org.springframework.http.HttpStatus.*;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@Autowired
	private WebTestClient testClient;

	@Test
	void getProductById(){
		int productId=1;
		testClient.get()
				.uri("/product/" + productId)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.productId").isEqualTo(productId);
	}

	@Test
	void getProductInvalidParameterString() {

		testClient.get()
				.uri("/product/no-integer")
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(BAD_REQUEST)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.path").isEqualTo("/product/no-integer")
				.jsonPath("$.message").isEqualTo("Type mismatch.");
	}

	@Test
	void getProductNotFound() {

		int productIdNotFound = 13;

		testClient.get()
				.uri("/product/" + productIdNotFound)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.path").isEqualTo("/product/" + productIdNotFound);
	}

	@Test
	void getProductInvalidParameterNegativeValue() {

		int productIdInvalid = -1;

		testClient.get()
				.uri("/product/" + productIdInvalid)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(UNPROCESSABLE_ENTITY)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.path").isEqualTo("/product/" + productIdInvalid);
	}

}
