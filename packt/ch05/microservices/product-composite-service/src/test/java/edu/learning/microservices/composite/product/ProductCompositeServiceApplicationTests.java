package edu.learning.microservices.composite.product;

import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.microservices.composite.product.services.ProductCompositeHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductCompositeServiceApplicationTests {

	private static final int PRODUCT_ID_OK = 1;
	private static final int PRODUCT_ID_NOT_FOUND = 2;
	private static final int PRODUCT_ID_INVALID = 3;

	@Autowired
	private WebTestClient testClient;

	@MockBean
	private ProductCompositeHelper helper;

	@BeforeEach
	protected void setup(){
		// happy cases
		Mockito.when(helper.getProduct(PRODUCT_ID_OK))
				.thenReturn(new ProductDTO(PRODUCT_ID_OK,"name",1,"mockAddress"));
		Mockito.when(helper.getReviews(PRODUCT_ID_OK))
				.thenReturn(Collections.singletonList(new ReviewDTO(PRODUCT_ID_OK, 1,"author","subject","content","mockAddress")));
		Mockito.when(helper.getRecommendations(PRODUCT_ID_OK))
				.thenReturn(Collections.singletonList(new RecommendationDTO(PRODUCT_ID_OK,1,"author",1, "content","mockAddress")));

		//sad cases

		Mockito.when(helper.getProduct(PRODUCT_ID_NOT_FOUND))
				.thenThrow(new NotFoundException("NOT FOUND: " + PRODUCT_ID_NOT_FOUND));
		Mockito.when(helper.getProduct(PRODUCT_ID_INVALID))
				.thenThrow(new InvalidInputException("INVALID: " + PRODUCT_ID_INVALID));
	}

	@Test
	public void getProductById(){
		testClient.get()
				.uri("/product-composite/"+PRODUCT_ID_OK)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.productId").isEqualTo(PRODUCT_ID_OK)
				.jsonPath("$.recommendations.length()").isEqualTo(1)
				.jsonPath("$.reviews.length()").isEqualTo(1);
	}

	@Test
	public void getProductNotFound(){
		testClient.get()
				.uri("/product-composite/"+PRODUCT_ID_NOT_FOUND)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.path").isEqualTo("/product-composite/" + PRODUCT_ID_NOT_FOUND)
				.jsonPath("$.message").isEqualTo("NOT FOUND: " + PRODUCT_ID_NOT_FOUND);
	}

	@Test
	void getProductInvalidInput() {

		testClient.get()
				.uri("/product-composite/" + PRODUCT_ID_INVALID)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY)
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.path").isEqualTo("/product-composite/" + PRODUCT_ID_INVALID)
				.jsonPath("$.message").isEqualTo("INVALID: " + PRODUCT_ID_INVALID);
	}

}
