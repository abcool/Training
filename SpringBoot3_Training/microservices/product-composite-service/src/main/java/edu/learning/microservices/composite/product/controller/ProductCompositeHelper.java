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
        this.productServiceUrl = "http://"+productServiceUrl+":"+productServicePort+"/product";
        this.recommendationServiceUrl = "http://"+recommendationServiceUrl+":"+ recommendationServicePort+"/recommendation";
        this.reviewServiceUrl = "http://"+reviewServiceUrl+":"+reviewServicePort+"/review";
    }
    @Override
    public ProductDTO createProduct(ProductDTO body) {

        try {
            String url = productServiceUrl;
            LOGGER.debug("Will post a new product to URL: {}", url);

            ProductDTO product = restTemplate.postForObject(url, body, ProductDTO.class);
            LOGGER.debug("Created a product with id: {}", product.productId());

            return product;

        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    @Override
    public ProductDTO getProduct(int productId) {
        LOGGER.info("Will call getProduct API on url: {}", productServiceUrl + "/"+ productId);
        String url = productServiceUrl + "/" + productId;
        try {
            ProductDTO product = restTemplate.getForObject(url, ProductDTO.class);
            return product;
        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }
    @Override
    public void deleteProduct(int productId) {
        try {
            String url = productServiceUrl + "/" + productId;
            LOGGER.debug("Will call the deleteProduct API on URL: {}", url);

            restTemplate.delete(url);

        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    @Override
    public RecommendationDTO createRecommendation(RecommendationDTO body) {

        try {
            String url = recommendationServiceUrl;
            LOGGER.debug("Will post a new recommendation to URL: {}", url);

            RecommendationDTO recommendation = restTemplate.postForObject(url, body, RecommendationDTO.class);
            LOGGER.debug("Created a recommendation with id: {}", recommendation.productId());

            return recommendation;

        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    @Override
    public List<RecommendationDTO> getRecommendations(int productId) {
        LOGGER.info(" Will call getRecommendations API on url: {}", recommendationServiceUrl+ "?productId=" + productId);
        String url = recommendationServiceUrl + "?productId=" + productId;
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
    public void deleteRecommendations(int productId) {
        try {
            String url = recommendationServiceUrl + "?productId=" + productId;
            LOGGER.debug("Will call the deleteRecommendations API on URL: {}", url);

            restTemplate.delete(url);

        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    @Override
    public ReviewDTO createReview(ReviewDTO body) {

        try {
            String url = reviewServiceUrl;
            LOGGER.debug("Will post a new review to URL: {}", url);

            ReviewDTO review = restTemplate.postForObject(url, body, ReviewDTO.class);
            LOGGER.debug("Created a review with id: {}", review.productId());

            return review;

        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }

    @Override
    public List<ReviewDTO> getReviews(int productId) {
        LOGGER.info("Will call getReviews API on url: {}", reviewServiceUrl + "?productId=" + productId);
    String url = reviewServiceUrl + "?productId=" + productId;
    try {
        List<ReviewDTO> reviews = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ReviewDTO>>() {
                }).getBody();
        LOGGER.debug("Found {} reviews for product with id {}", reviews.size(), productId);
        return reviews;
        } catch (Exception ex) {
        LOGGER.warn("Got an exception while requesting reviews, return zero reviews: {}", ex.getMessage());
        return List.of();
        }
    }
    @Override
    public void deleteReviews(int productId) {
        try {
            String url = reviewServiceUrl + "?productId=" + productId;
            LOGGER.debug("Will call the deleteReviews API on URL: {}", url);

            restTemplate.delete(url);

        } catch (HttpClientErrorException ex) {
            throw handleHttpClientException(ex);
        }
    }
    private RuntimeException handleHttpClientException(HttpClientErrorException ex) {
        switch (HttpStatus.resolve(ex.getStatusCode().value())) {

            case NOT_FOUND:
                return new NotFoundException(getErrorMessage(ex));

            case UNPROCESSABLE_ENTITY:
                return new InvalidInputException(getErrorMessage(ex));

            default:
                LOGGER.warn("Got an unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
                LOGGER.warn("Error body: {}", ex.getResponseBodyAsString());
                return ex;
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
