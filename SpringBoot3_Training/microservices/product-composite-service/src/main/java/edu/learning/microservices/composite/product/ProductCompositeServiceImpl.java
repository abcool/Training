package edu.learning.microservices.composite.product;

import edu.learning.api.composite.product.*;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.util.http.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductCompositeServiceImpl implements IProductComposite {
    private final ProductCompositeHelper helper;
    private final ServiceUtil serviceUtil;
    @Autowired
    public ProductCompositeServiceImpl(ProductCompositeHelper helper, ServiceUtil serviceUtil) {
        this.helper = helper;
        this.serviceUtil= serviceUtil;
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
    private ProductCompositeDTO createProductCompositeDTO(ProductDTO product,
                                                           List<RecommendationDTO> recommendations,
                                                           List<ReviewDTO> reviews,
                                                           String productCompositeServiceAddress) {
        int productId = product.productId();
        String productName = product.name();
        int weight = product.weight();

        List<RecommendationSummaryDTO> recommendationSummary = recommendations.stream().map(recommendation->
                new RecommendationSummaryDTO(recommendation.recommendationId(), recommendation.author(),recommendation.rate()))
                .collect(Collectors.toUnmodifiableList());

        List<ReviewSummaryDTO> reviewSummary = reviews.stream().map(review->new ReviewSummaryDTO(review.reviewId(),review.author(),review.subject()))
                .collect(Collectors.toUnmodifiableList());
        String productAddress = product.serviceAddress();
        String reviewAddress = reviews.getFirst().serviceAddress();
        String recommendationAddress = recommendations.getFirst().serviceAddress();
        ServiceAddressDTO serviceAddress = new ServiceAddressDTO(productCompositeServiceAddress,productAddress, reviewAddress, recommendationAddress);
        return new ProductCompositeDTO(productId, productName, weight, recommendationSummary, reviewSummary, serviceAddress);
    }
}
