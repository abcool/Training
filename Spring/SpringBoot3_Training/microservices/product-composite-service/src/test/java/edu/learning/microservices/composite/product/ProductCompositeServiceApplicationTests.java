package edu.learning.microservices.composite.product;


import edu.learning.api.composite.ProductCompositeDTO;
import edu.learning.api.composite.RecommendationSummaryDTO;
import edu.learning.api.composite.ReviewSummaryDTO;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.microservices.composite.product.controller.ProductCompositeHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import static org.springframework.http.HttpStatus.*;
import java.util.Collections;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductCompositeServiceApplicationTests {
    private static final int PRODUCT_ID_OK = 1;
    private static final int PRODUCT_ID_NOT_FOUND = 2;
    private static final int PRODUCT_ID_INVALID = 3;

    @Autowired
    private WebTestClient testClient;
    @MockitoBean
    private ProductCompositeHelper helper;
    @BeforeEach
    public void setup(){
        Mockito.when(helper.getProduct(PRODUCT_ID_OK))
                .thenReturn(new ProductDTO(PRODUCT_ID_OK,"name",1, "mock-address"));
        Mockito.when(helper.getRecommendations(PRODUCT_ID_OK))
                .thenReturn(Collections.singletonList(
                        new RecommendationDTO(PRODUCT_ID_OK,1,"author",1,"content","mock-address")
                ));
        Mockito.when(helper.getReviews(PRODUCT_ID_OK))
                .thenReturn(Collections.singletonList(
                        new ReviewDTO(PRODUCT_ID_OK,1,"author","subject","content","mock-address")
                ));
        Mockito.when(helper.getProduct(PRODUCT_ID_NOT_FOUND))
                .thenThrow(new NotFoundException(PRODUCT_ID_NOT_FOUND +" not found"));
        Mockito.when(helper.getProduct(PRODUCT_ID_INVALID))
                .thenThrow(new InvalidInputException("Invalid productId: " + PRODUCT_ID_INVALID));


        Mockito.when(helper.createProduct(Mockito.any()))
                .thenReturn(new ProductDTO(PRODUCT_ID_OK,"name",1, "mock-address"));
        Mockito.when(helper.createRecommendation(Mockito.any()))
                .thenReturn(new RecommendationDTO(PRODUCT_ID_OK,0,"",0,"","mock-address"));
        Mockito.when(helper.createReview(Mockito.any()))
                .thenReturn(new ReviewDTO(PRODUCT_ID_OK,0,"","","","mock-address"));
    }

//    @Test
//    void createCompositeProduct1() {
//
//        ProductCompositeDTO compositeProduct = new ProductCompositeDTO(1, "name", 1, Collections.emptyList(), Collections.emptyList(), null);
//
//        createProduct(compositeProduct, OK);
//    }

    @Test
    void createCompositeProduct2() {
        ProductCompositeDTO compositeProduct = new ProductCompositeDTO(1, "name", 1,
                Collections.singletonList(new RecommendationSummaryDTO(1, "a", 1, "c")),
                Collections.singletonList(new ReviewSummaryDTO(1, "a", "s", "c")), null);

        createProduct(compositeProduct, OK);
    }

    @Test
    void deleteCompositeProduct() {
        ProductCompositeDTO compositeProduct = new ProductCompositeDTO(1, "name", 1,
                Collections.singletonList(new RecommendationSummaryDTO(1, "a", 1, "c")),
                Collections.singletonList(new ReviewSummaryDTO(1, "a", "s", "c")), null);

        createProduct(compositeProduct, OK);

        deleteProduct(compositeProduct.productId(), OK);
        deleteProduct(compositeProduct.productId(), OK);
    }
    @Test
    public void getProductById(){
        testClient.get()
                .uri("/product-composite/" + PRODUCT_ID_OK)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.productId").isEqualTo(PRODUCT_ID_OK)
                .jsonPath("$.recommendations.length()").isEqualTo(1)
                .jsonPath("$.reviews.length()").isEqualTo(1);
    }

    @Test
    public void getProductNotFound(){
        testClient.get()
                .uri("/product-composite/" + PRODUCT_ID_NOT_FOUND)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("$.message").isEqualTo(PRODUCT_ID_NOT_FOUND + " not found");
    }
    @Test
    public void getProductInvalidInput(){
        testClient.get()
                .uri("/product-composite/" + PRODUCT_ID_INVALID)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY)
                .expectBody()
                .jsonPath("$.message").isEqualTo("Invalid productId: " + PRODUCT_ID_INVALID);
    }

    private void createProduct(ProductCompositeDTO compositeProduct, HttpStatus expectedStatus) {
        testClient.post()
                .uri("/product-composite")
                .body(Mono.just(compositeProduct), ProductCompositeDTO.class)
                .exchange()
                .expectStatus().isEqualTo(expectedStatus);
    }

    private void deleteProduct(int productId, HttpStatus expectedStatus) {
        testClient.delete()
                .uri("/product-composite/" + productId)
                .exchange()
                .expectStatus().isEqualTo(expectedStatus);
    }
}
