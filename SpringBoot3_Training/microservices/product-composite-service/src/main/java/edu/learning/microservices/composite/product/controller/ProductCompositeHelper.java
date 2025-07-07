package edu.learning.microservices.composite.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.learning.api.core.product.IProduct;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.core.recommendation.IRecommendation;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.core.review.IReview;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.util.http.HttpErrorDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
@Component
public class ProductCompositeHelper implements IProduct, IReview, IRecommendation {
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;
    private final String productServiceUrl;
    private final String recommendationServiceUrl;
    private final String reviewServiceUrl;
    private final Logger LOGGER = LogManager.getLogger(ProductCompositeHelper.class);
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
        LOGGER.info("Will call getProduct API on url: {}", productServiceUrl + productId);
        String url = productServiceUrl + productId;
        try {
            ProductDTO product = restTemplate.getForObject(url, ProductDTO.class);
            return product;
        } catch (HttpClientErrorException e) {
            switch (HttpStatus.resolve(e.getStatusCode().value())){
                case NOT_FOUND :
                    throw new NotFoundException(getErrorMessage(e));
                case UNPROCESSABLE_ENTITY:
                    throw new InvalidInputException(getErrorMessage(e));
                default:
                    LOGGER.error("Got an unexpected HTTP error: {}, will rethrow it", e.getStatusCode());
                    LOGGER.error("Error body: {}", e.getResponseBodyAsString());
                    throw e;
            }
        }
    }

    @Override
    public List<RecommendationDTO> getRecommendations(int productId) {
        LOGGER.info(" Will call getRecommendations API on url: {}", recommendationServiceUrl + productId);
        String url = recommendationServiceUrl + productId;
        try {
            List<RecommendationDTO> recommendations = restTemplate.exchange(url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<RecommendationDTO>>() {
                    }).getBody();
            LOGGER.debug("Found {} recommendations for product with id {}", recommendations.size(), productId);
            return recommendations;
        } catch (Exception e) {
           LOGGER.error("Got an error while trying to get recommendations for product with id {}: {}", productId, e.getMessage());
           return List.of();
        }
    }

    @Override
    public List<ReviewDTO> getReviews(int productId) {
        LOGGER.info("Will call getReviews API on url: {}", reviewServiceUrl + productId);
    String url = reviewServiceUrl + productId;
    try {
        List<ReviewDTO> reviews = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ReviewDTO>>() {
                }).getBody();
        LOGGER.debug("Found {} reviews for product with id {}", reviews.size(), productId);
        return reviews;
        } catch (Exception e) {
            if(e.getMessage().contains(String.valueOf(HttpStatus.NOT_FOUND.value()))){
                throw new NotFoundException("No reviews found for productId: " + productId);
            }
            LOGGER.error("Got an error while trying to get reviews for product with id {}: {}", productId, e.getMessage());
            return List.of();
        }
    }
    private String getErrorMessage(HttpClientErrorException ex) {
        try {
            return mapper.readValue(ex.getResponseBodyAsString(), HttpErrorDTO.class).message();
        } catch (IOException ioex) {
            return ioex.getMessage();
        }
    }
}
