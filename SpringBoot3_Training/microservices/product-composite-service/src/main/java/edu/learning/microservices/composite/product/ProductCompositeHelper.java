package edu.learning.microservices.composite.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.learning.api.core.product.IProduct;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.core.recommendation.IRecommendation;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.core.review.IReview;
import edu.learning.api.core.review.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class ProductCompositeHelper implements IProduct, IReview, IRecommendation {
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private final String productServiceUrl;
    private final String recommendationServiceUrl;
    private final String reviewServiceUrl;
    @Autowired
    public ProductCompositeHelper(RestTemplate restTemplate, ObjectMapper mapper,
                                  @Value("${app.product-service.host}")
                                  String productServiceUrl,
                                  @Value("${app.product-service.port}")
                                  int productServicePort,
                                  @Value("${app.recommendation-service.host}")
                                  String recommendationServiceUrl,
                                  @Value("${app.recommendation-service.port}")
                                  int recommendationServicePort,
                                  @Value("${app.review-service.host}")
                                  String reviewServiceUrl,
                                  @Value("${app.review-service.port}")
                                  int reviewServicePort) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        this.productServiceUrl = "http://"+productServiceUrl+":"+productServicePort+"/product/";
        this.recommendationServiceUrl = "http://"+recommendationServiceUrl+":"+ recommendationServicePort+"/recommendation?productId=";
        this.reviewServiceUrl = "http://"+reviewServiceUrl+":"+reviewServicePort+"/review?productId=";
    }

    @Override
    public ProductDTO getProduct(int productId) {
        String url = productServiceUrl + productId;
        ProductDTO product = restTemplate.getForObject(url, ProductDTO.class);
        return product;
    }

    @Override
    public List<RecommendationDTO> getRecommendations(int productId) {
        String url = recommendationServiceUrl + productId;
        List<RecommendationDTO> recommendations = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<RecommendationDTO>>() {}).getBody();
        return recommendations;
    }

    @Override
    public List<ReviewDTO> getReviews(int productId) {
    String url = reviewServiceUrl + productId;
    List<ReviewDTO> reviews = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ReviewDTO>>() {}).getBody();
        return reviews;
    }
}
