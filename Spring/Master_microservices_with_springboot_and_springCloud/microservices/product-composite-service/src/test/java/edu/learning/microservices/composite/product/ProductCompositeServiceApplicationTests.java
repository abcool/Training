package edu.learning.microservices.composite.product;

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import edu.learning.api.composite.dto.ProductCompositeDTO;
import edu.learning.api.composite.dto.RecommendationSummaryDTO;
import edu.learning.api.composite.dto.ReviewSummaryDTO;
import edu.learning.api.composite.dto.ServiceAddressesDTO;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.microservices.composite.product.integration.ProductCompositeIntegration;
import edu.learning.util.http.ServiceUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;

@SpringBootTest
@AutoConfigureWebTestClient
class ProductCompositeServiceApplicationTests {

    private static final int PRODUCT_ID_OK = 1;
    private static final int PRODUCT_ID_NOT_FOUND = 2;
    private static final int PRODUCT_ID_INVALID = 3;

    @Autowired
    private WebTestClient client;

    @MockitoBean
    private ProductCompositeIntegration compositeIntegration;

    @BeforeEach
    void setUp() {
        when(compositeIntegration.getProduct(PRODUCT_ID_OK))
                .thenReturn(Mono.just(ResponseEntity.ok(new ProductDTO(PRODUCT_ID_OK, "name", 1, "mock-address"))));
        when(compositeIntegration.getRecommendations(PRODUCT_ID_OK))
                .thenReturn(Mono.just(ResponseEntity.ok(singletonList(
                        new RecommendationDTO(PRODUCT_ID_OK, 1, "author", 1, "content", "mock address")
                ))));
        when(compositeIntegration.getReviews(PRODUCT_ID_OK))
                .thenReturn(Mono.just(ResponseEntity.ok(singletonList(
                        new ReviewDTO(PRODUCT_ID_OK, 1, "author", "subject", "content", "mock address")
                ))));

        when(compositeIntegration.getProduct(PRODUCT_ID_NOT_FOUND))
                .thenReturn(Mono.error(new NotFoundException("NOT FOUND: " + PRODUCT_ID_NOT_FOUND)));

        when(compositeIntegration.getProduct(PRODUCT_ID_INVALID))
                .thenReturn(Mono.error(new InvalidInputException("INVALID: " + PRODUCT_ID_INVALID)));

        when(compositeIntegration.createProduct(any(ProductDTO.class)))
                .thenReturn(Mono.just(ResponseEntity.ok(new ProductDTO(1, "name", 1, "mock-address"))));
        when(compositeIntegration.createRecommendation(any(RecommendationDTO.class)))
                .thenReturn(Mono.just(ResponseEntity.ok(new RecommendationDTO(1, 1, "author", 1, "content", "mock address"))));
        when(compositeIntegration.createReview(any(ReviewDTO.class)))
                .thenReturn(Mono.just(ResponseEntity.ok(new ReviewDTO(1, 1, "author", "subject", "content", "mock address"))));

        when(compositeIntegration.deleteProduct(anyInt()))
                .thenReturn(Mono.just(ResponseEntity.ok().build()));
        when(compositeIntegration.deleteRecommendations(anyInt()))
                .thenReturn(Mono.just(ResponseEntity.ok().build()));
        when(compositeIntegration.deleteReviews(anyInt()))
                .thenReturn(Mono.just(ResponseEntity.ok().build()));
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

    @Test
    void createCompositeProduct1() {

        ProductCompositeDTO compositeProduct = new ProductCompositeDTO(1, "name", 1,
                java.util.Collections.emptyList(), java.util.Collections.emptyList(), null);

        postAndVerifyProduct(compositeProduct, CREATED);
    }

    @Test
    void createCompositeProduct2() {
        ProductCompositeDTO compositeProduct = new ProductCompositeDTO(1, "name", 1,
                singletonList(new RecommendationSummaryDTO(1, "a", 1,"some recommendation content")),
                singletonList(new ReviewSummaryDTO(1, "a", "s", "some review content")),
                null);

        postAndVerifyProduct(compositeProduct, CREATED);
    }

    @Test
    void deleteCompositeProduct() {
        ProductCompositeDTO compositeProduct = new ProductCompositeDTO(1, "name", 1,
                singletonList(new RecommendationSummaryDTO(1, "a", 1,"some recommendation content")),
                singletonList(new ReviewSummaryDTO(1, "a", "s","some review content")), null);

        postAndVerifyProduct(compositeProduct, CREATED);

        deleteAndVerifyProduct(compositeProduct.getProductId(), NO_CONTENT);
        deleteAndVerifyProduct(compositeProduct.getProductId(), NO_CONTENT);
    }
    private void postAndVerifyProduct(ProductCompositeDTO compositeProduct, HttpStatus expectedStatus) {
        client.post()
                .uri("/product-composite")
                .body(Mono.just(compositeProduct), ProductCompositeDTO.class)
                .exchange()
                .expectStatus().isEqualTo(expectedStatus);
    }

    private void deleteAndVerifyProduct(int productId, HttpStatus expectedStatus) {
        client.delete()
                .uri("/product-composite/" + productId)
                .exchange()
                .expectStatus().isEqualTo(expectedStatus);
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
            return builder -> builder.mixIn(ProductCompositeDTO.class, ProductCompositeDTOMixin.class)
                    .mixIn(RecommendationSummaryDTO.class, RecommendationSummaryDTOMixin.class)
                    .mixIn(ReviewSummaryDTO.class, ReviewSummaryDTOMixin.class);
        }
    }

    abstract static class ProductCompositeDTOMixin {
        @JsonCreator
        public ProductCompositeDTOMixin(
                @JsonProperty("productId") int productId,
                @JsonProperty("name") String name,
                @JsonProperty("weight") int weight,
                @JsonProperty("recommendations") java.util.List<RecommendationSummaryDTO> recommendations,
                @JsonProperty("reviews") java.util.List<ReviewSummaryDTO> reviews,
                @JsonProperty("serviceAddresses") ServiceAddressesDTO serviceAddresses) {
        }
    }

    abstract static class RecommendationSummaryDTOMixin {
        @JsonCreator
        public RecommendationSummaryDTOMixin(
                @JsonProperty("recommendationId") int recommendationId,
                @JsonProperty("author") String author,
                @JsonProperty("rate") int rate,
                @JsonProperty("content") String content) {
        }
    }

    abstract static class ReviewSummaryDTOMixin {
        @JsonCreator
        public ReviewSummaryDTOMixin(
                @JsonProperty("reviewId") int reviewId,
                @JsonProperty("author") String author,
                @JsonProperty("subject") String subject,
                @JsonProperty("content") String content) {
        }
    }
}