package edu.learning.microservices.core.review;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewServiceApplicationTests {
	private final int PRODUCT_ID_OK = 1;
	private final int PRODUCT_ID_NOT_FOUND = 213;
	private final int PRODUCT_ID_INVALID = -1;

	@Autowired
	private WebTestClient testClient;

	@Test
	void getReviewsByProductId() {
		testClient.get()
				.uri("/review?productId=" + PRODUCT_ID_OK)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$.length()").isEqualTo(3)
				.jsonPath("$[0].productId").isEqualTo(PRODUCT_ID_OK);
	}

	@Test
	void getReviewsNotFound() {
		testClient.get()
				.uri("/review?productId=" + PRODUCT_ID_NOT_FOUND)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody()
				.jsonPath("$.length()").isEqualTo(4);
	}

	@Test
	void getReviewsInvalidProductID() {
		testClient.get()
				.uri("/review?productId=" + PRODUCT_ID_INVALID)
				.exchange()
				.expectStatus().isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY)
				.expectBody()
				.jsonPath("$.path").isEqualTo("/review")
				.jsonPath("$.message").isEqualTo("Invalid productId: " + PRODUCT_ID_INVALID);
	}

	@Test
	void getReviewsMissingParameter() {
		testClient.get()
				.uri("/review")
				.exchange()
				.expectStatus().isEqualTo(HttpStatus.BAD_REQUEST)
				.expectBody()
				.jsonPath("$.path").isEqualTo("/review")
				.jsonPath("$.message").isEqualTo("400 BAD_REQUEST \"Required query parameter 'productId' is not present.\"");
	}

	@Test
	void getReviewsInvalidParameter() {
		testClient.get()
				.uri("/review?productId=no-integer")
				.exchange()
				.expectStatus().isEqualTo(HttpStatus.BAD_REQUEST)
				.expectBody()
				.jsonPath("$.path").isEqualTo("/review")
				.jsonPath("$.message").isEqualTo("400 BAD_REQUEST \"Type mismatch.\"");
	}



}
