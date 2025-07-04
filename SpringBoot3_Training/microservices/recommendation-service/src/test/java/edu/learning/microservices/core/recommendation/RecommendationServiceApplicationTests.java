package edu.learning.microservices.core.recommendation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecommendationServiceApplicationTests {

	@Autowired
	private WebTestClient testClient;

	private final int PRODUCT_ID_OK = 1;
	private final int PRODUCT_ID_NOT_FOUND = 13;
	private final int PRODUCT_ID_INVALID = -1;

	@Test
	public void getRecommendationsByProductId() {
		testClient.get()
				.uri("/recommendation?productId=" + PRODUCT_ID_OK)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$.length()").isEqualTo(3)
				.jsonPath("$[0].productId").isEqualTo(PRODUCT_ID_OK);
	}

	@Test
	public void getRecommendationsNotFound() {
		testClient.get()
				.uri("/recommendation?productId=" + PRODUCT_ID_NOT_FOUND)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody()
				.jsonPath("$.length()").isEqualTo(4);
	}

	@Test
	public void getRecommendationsInvalidProductId() {
		testClient.get()
				.uri("/recommendation?productId=" + PRODUCT_ID_INVALID)
				.exchange()
				.expectStatus().isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY) // Unprocessable Entity
				.expectBody()
				.jsonPath("$.path").isEqualTo("/recommendation")
				.jsonPath("$.message").isEqualTo("Invalid productId: " + PRODUCT_ID_INVALID);
	}

	@Test
	void getRecommendationsMissingParameter() {

		testClient.get()
				.uri("/recommendation")
				.exchange()
				.expectStatus().isEqualTo(HttpStatus.BAD_REQUEST) // Bad Request
				.expectBody()
				.jsonPath("$.path").isEqualTo("/recommendation")
				.jsonPath("$.message").isEqualTo("400 BAD_REQUEST \"Required query parameter 'productId' is not present.\"");
	}

	@Test
	void getRecommendationsInvalidParameter() {

		testClient.get()
				.uri("/recommendation?productId=no-integer")
				.exchange()
				.expectStatus().isEqualTo(HttpStatus.BAD_REQUEST)
				.expectBody()
				.jsonPath("$.path").isEqualTo("/recommendation")
				.jsonPath("$.message").isEqualTo("400 BAD_REQUEST \"Type mismatch.\"");
	}

}
