package edu.learning.microservices.core.recommendation;

import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.microservices.core.recommendation.config.MongoTestConfig;
import edu.learning.microservices.core.recommendation.persistence.RecommendationRepository;
import edu.learning.util.http.ServiceUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.*;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(MongoTestConfig.class)
class RecommendationServiceApplicationTests {

	@Autowired
	private WebTestClient client;

	@Autowired
	private RecommendationRepository repository;

	@MockitoBean
	private ServiceUtil serviceUtil;

	@BeforeEach
	void setupDb() {
		repository.deleteAll().block();
		when(serviceUtil.getServiceAddress()).thenReturn("test-address");
	}

	@Test
	void getRecommendationsByProductId() {

		int productId = 1;

		postAndVerifyRecommendation(productId, 1, CREATED);
		postAndVerifyRecommendation(productId, 2, CREATED);
		postAndVerifyRecommendation(productId, 3, CREATED);

		assertEquals(3, repository.findByProductId(productId).count().block());

		getAndVerifyRecommendationsByProductId(productId, OK)
				.jsonPath("$.length()").isEqualTo(3)
				.jsonPath("$[2].productId").isEqualTo(productId)
				.jsonPath("$[2].recommendationId").isEqualTo(3);
	}

	@Test
	void duplicateError() {

		int productId = 1;
		int recommendationId = 1;

		postAndVerifyRecommendation(productId, recommendationId, CREATED)
				.jsonPath("$.productId").isEqualTo(productId)
				.jsonPath("$.recommendationId").isEqualTo(recommendationId);

		assertEquals(1, repository.findByProductId(productId).count().block());

		postAndVerifyRecommendation(productId, recommendationId, UNPROCESSABLE_ENTITY)
				.jsonPath("$.path").isEqualTo("/recommendation")
				.jsonPath("$.message").isEqualTo("Duplicate key, Recommendation Id:1");

		assertEquals(1, repository.findByProductId(productId).count().block());
	}

	@Test
	void deleteRecommendations() {

		int productId = 1;
		int recommendationId = 1;

		postAndVerifyRecommendation(productId, recommendationId, CREATED);
		assertEquals(1, repository.findByProductId(productId).count().block());

		deleteAndVerifyRecommendationsByProductId(productId, NO_CONTENT);
		assertEquals(0, repository.findByProductId(productId).count().block());

		deleteAndVerifyRecommendationsByProductId(productId, NO_CONTENT);
	}

	@Test
	void getRecommendationsMissingParameter() {

		getAndVerifyRecommendationsByProductId("", BAD_REQUEST)
				.jsonPath("$.path").isEqualTo("/recommendation")
				.jsonPath("$.message").isEqualTo("Required query parameter 'productId' is not present.");
	}

	@Test
	void getRecommendationsInvalidParameter() {

		getAndVerifyRecommendationsByProductId("?productId=no-integer", BAD_REQUEST)
				.jsonPath("$.path").isEqualTo("/recommendation")
				.jsonPath("$.message").isEqualTo("Type mismatch.");
	}

	@Test
	void getRecommendationsNotFound() {

		getAndVerifyRecommendationsByProductId("?productId=113", OK)
				.jsonPath("$.length()").isEqualTo(0);
	}

	@Test
	void getRecommendationsInvalidParameterNegativeValue() {

		int productIdInvalid = -1;

		getAndVerifyRecommendationsByProductId("?productId=" + productIdInvalid, UNPROCESSABLE_ENTITY)
				.jsonPath("$.path").isEqualTo("/recommendation")
				.jsonPath("$.message").isEqualTo("Product id must be greater than zero");
	}

	private WebTestClient.BodyContentSpec getAndVerifyRecommendationsByProductId(int productId, HttpStatus expectedStatus) {
		return getAndVerifyRecommendationsByProductId("?productId=" + productId, expectedStatus);
	}

	private WebTestClient.BodyContentSpec getAndVerifyRecommendationsByProductId(String productIdQuery, HttpStatus expectedStatus) {
		return client.get()
				.uri("/recommendation" + productIdQuery)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec postAndVerifyRecommendation(int productId, int recommendationId, HttpStatus expectedStatus) {
		RecommendationDTO recommendation = new RecommendationDTO(productId, recommendationId, "Author " + recommendationId, recommendationId+1, "Content " + recommendationId, serviceUtil.getServiceAddress());
		return client.post()
				.uri("/recommendation")
				.body(Mono.just(recommendation), RecommendationDTO.class)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody();
	}

	private WebTestClient.BodyContentSpec deleteAndVerifyRecommendationsByProductId(int productId, HttpStatus expectedStatus) {
		return client.delete()
				.uri("/recommendation?productId=" + productId)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(expectedStatus)
				.expectBody();
	}

}
