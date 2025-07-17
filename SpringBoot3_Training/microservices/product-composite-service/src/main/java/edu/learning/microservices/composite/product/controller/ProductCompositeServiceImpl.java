package edu.learning.microservices.composite.product.controller;

import edu.learning.api.composite.product.*;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductCompositeServiceImpl implements IProductComposite {
    private static final Logger Logger = LogManager.getLogger(ProductCompositeServiceImpl.class);

    private final ProductCompositeHelper helper;
    private final ServiceUtil serviceUtil;
    @Autowired
    public ProductCompositeServiceImpl(ProductCompositeHelper helper, ServiceUtil serviceUtil) {
        this.helper = helper;
        this.serviceUtil= serviceUtil;
    }
    @Override
    public ProductCompositeDTO createProduct(ProductCompositeDTO body) {

        try {

            Logger.debug("createCompositeProduct: creates a new composite entity for productId: {}", body.productId());

            ProductDTO product = new ProductDTO(body.productId(), body.name(), body.weight(), null);
            product = helper.createProduct(product);

            List<RecommendationDTO> recommendationDTOList = new ArrayList<>();
            if (body.recommendations() != null) {
                body.recommendations().forEach(r -> {
                    RecommendationDTO recommendation = new RecommendationDTO(body.productId(), r.recommendationId(), r.author(), r.rate(), r.content(), null);
                    RecommendationDTO output = helper.createRecommendation(recommendation);
                    recommendationDTOList.add(output);
                });
            }

            Logger.debug(" Successfully created recommendations for productId: {}", body.productId());
            List<ReviewDTO> reviewDTOList = new ArrayList<>();
            if (body.reviews() != null) {
                body.reviews().forEach(r -> {
                    ReviewDTO review = new ReviewDTO(body.productId(), r.reviewId(), r.author(), r.subject(), r.content(), null);
                    ReviewDTO output = helper.createReview(review);
                    reviewDTOList.add(output);
                });
            }
            Logger.debug(" Successfully created reviews for productId: {}", body.productId());

            Logger.debug("createCompositeProduct: composite entities created for productId: {}", body.productId());

            return createProductCompositeDTO(product, recommendationDTOList, reviewDTOList, serviceUtil.getServiceAddress());


        } catch (RuntimeException re) {
            Logger.warn("createCompositeProduct failed", re);
            throw re;
        }
    }
    @Override
    public ProductCompositeDTO getProduct(int productId) {

        ProductDTO product = helper.getProduct(productId);
        if(product==null)
            throw new NotFoundException("No product found for productId: " + productId);
        List<RecommendationDTO> recommendations = helper.getRecommendations(productId);
        List<ReviewDTO> reviews = helper.getReviews(productId);
        return createProductCompositeDTO(product, recommendations, reviews, serviceUtil.getServiceAddress());
    }
    @Override
    public void deleteProduct(int productId) {

        Logger.debug("deleteCompositeProduct: Deletes a product aggregate for productId: {}", productId);

        helper.deleteProduct(productId);

        helper.deleteRecommendations(productId);

        helper.deleteReviews(productId);

        Logger.debug("deleteCompositeProduct: aggregate entities deleted for productId: {}", productId);
    }
    private ProductCompositeDTO createProductCompositeDTO(ProductDTO product,
                                                           List<RecommendationDTO> recommendations,
                                                           List<ReviewDTO> reviews,
                                                           String productCompositeServiceAddress) {
        int productId = product.productId();
        String productName = product.name();
        int weight = product.weight();

        List<RecommendationSummaryDTO> recommendationSummary = recommendations.stream().map(recommendation->
                new RecommendationSummaryDTO(recommendation.recommendationId(), recommendation.author(),recommendation.rate(), recommendation.content()))
                .toList();

        List<ReviewSummaryDTO> reviewSummary = reviews.stream().map(review->new ReviewSummaryDTO(review.reviewId(),review.author(),review.subject(), review.content()))
                .toList();
        String productAddress = product.serviceAddress();
        String reviewAddress = reviews.getFirst().serviceAddress();
        String recommendationAddress = recommendations.getFirst().serviceAddress();
        ServiceAddressDTO serviceAddress = new ServiceAddressDTO(productCompositeServiceAddress,productAddress, reviewAddress, recommendationAddress);
        return new ProductCompositeDTO(productId, productName, weight, recommendationSummary, reviewSummary, serviceAddress);
    }
}
