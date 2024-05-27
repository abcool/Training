package edu.learning.microservices.composite.product.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.learning.api.core.product.IProduct;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.core.recommendation.IRecommendation;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.core.review.IReview;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.util.http.CustomHttpError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProductCompositeHelper implements IProduct, IRecommendation, IReview {

    private static final Logger log = LogManager.getLogger(ProductCompositeHelper.class);

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    private final String productServiceUrl;

    private final String recommendationServiceUrl;

    private final String reviewServiceUrl;

    public ProductCompositeHelper(RestTemplate restTemplate,
                                  ObjectMapper mapper,
                                  @Value("${app.product-service.host}") String productServiceHost,
                                  @Value("${app.product-service.port}") int productServicePort,
                                  @Value("${app.recommendation-service.host}") String recommendationServiceHost,
                                  @Value("${app.recommendation-service.port}") int recommendationServicePort,
                                  @Value("${app.review-service.host}") String reviewServiceHost,
                                  @Value("${app.review-service.port}") int reviewServicePort) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
        this.productServiceUrl = "http://"+productServiceHost+":"+productServicePort+"/product/";
        this.recommendationServiceUrl = "http://"+recommendationServiceHost+":"+recommendationServicePort+"/recommendation?productId=";
        this.reviewServiceUrl = "http://"+reviewServiceHost+":"+reviewServicePort+"/review?productId=";
    }

    @Override
    public ProductDTO getProduct(int productId) {
        try {
            String url = productServiceUrl + productId;
            log.debug("Will call getProduct API on URL: {}", url);

            ProductDTO product = restTemplate.getForObject(url, ProductDTO.class);
            log.debug("Found a product with id: {}", product.getProductId());

            return product;

        } catch (HttpClientErrorException ex) {

            switch (ex.getStatusCode().value()) {
                case 404:
                    throw new NotFoundException(getErrorMessage(ex));

                case 422:
                    throw new InvalidInputException(getErrorMessage(ex));

                default:
                    System.out.println(ex.getResponseBodyAsString());
                    log.warn("Got an unexpected HTTP error: {}, will rethrow it", ex.getStatusCode());
                    log.warn("Error body: {}", ex.getResponseBodyAsString());
                    throw ex;
            }
        }

    }

    @Override
    public List<RecommendationDTO> getRecommendations(int productId) {
        try {
            String url = recommendationServiceUrl + productId;

            log.debug("Will call getRecommendations API on URL: {}", url);
            List<RecommendationDTO> recommendations = restTemplate
                    .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RecommendationDTO>>() {})
                    .getBody();

            log.debug("Found {} recommendations for a product with id: {}", recommendations.size(), productId);
            return recommendations;

        } catch (Exception ex) {
            log.warn("Got an exception while requesting recommendations, return zero recommendations: {}", ex.getMessage());
            return new ArrayList<RecommendationDTO>();
        }
    }

    @Override
    public List<ReviewDTO> getReviews(int productId) {
        try {
            String url = reviewServiceUrl + productId;

            log.debug("Will call getReviews API on URL: {}", url);
            List<ReviewDTO> reviews = restTemplate
                    .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<ReviewDTO>>() {})
                    .getBody();

            log.debug("Found {} reviews for a product with id: {}", reviews.size(), productId);
            return reviews;

        } catch (Exception ex) {
            log.warn("Got an exception while requesting reviews, return zero reviews: {}", ex.getMessage());
            return new ArrayList<ReviewDTO>();
        }
    }
    private String getErrorMessage(HttpClientErrorException ex) {
        try {
            return mapper.readValue(ex.getResponseBodyAsString(), CustomHttpError.class).getMessage();
        } catch (IOException ioex) {
            return ex.getMessage();
        }
    }
}
