package edu.learning.microservices.composite.product.services;

import edu.learning.api.composite.*;
import edu.learning.api.core.product.ProductDTO;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.util.http.ServiceUtility;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductCompositeServiceImpl implements IProductComposite {
    private final ServiceUtility serviceUtility;
    private ProductCompositeHelper helper;

    public ProductCompositeServiceImpl(ServiceUtility serviceUtility, ProductCompositeHelper helper) {
        this.serviceUtility = serviceUtility;
        this.helper = helper;
    }

    @Override
    public ProductAggregateDTO getProduct(int productId) {
        ProductDTO product = helper.getProduct(productId);
        if (product == null) {
            throw new NotFoundException("No product found for productId: " + productId);
        }
        List<RecommendationDTO> recommendations = helper.getRecommendations(productId);
        List<ReviewDTO> reviews = helper.getReviews(productId);
        return createProductAggregate(product, recommendations, reviews, serviceUtility.getServiceAddress());
    }

    private ProductAggregateDTO createProductAggregate(ProductDTO product, List<RecommendationDTO> recommendations, List<ReviewDTO> reviews, String serviceAddress) {
        int productId = product.getProductId();
        String productName = product.getName();
        int weight = product.getWeight();
        List<RecommendationSummaryDTO> recommendationSummaries = recommendations==null?null:recommendations.stream().map(
                recommendation -> new RecommendationSummaryDTO(
                        recommendation.getRecommendationId(), recommendation.getAuthor(),recommendation.getRate())
        ).collect(Collectors.toList());
        List<ReviewSummaryDTO> reviewsSummary = reviews==null?null:reviews.stream().map(
                review -> new ReviewSummaryDTO(review.getReviewId(), review.getAuthor(),review.getSubject())
        ).collect(Collectors.toList());
        String productAddress = product.getServiceAddress();
        String reviewAddress = (reviews!=null && reviews.size()>0)?reviews.get(0).getServiceAddress():"";
        String recommendationAddress = (recommendations!=null && recommendations.size()>0)?recommendations.get(0).getServiceAddress():"";
        ServiceAddressDTO serviceAddresses = new ServiceAddressDTO(serviceAddress,productAddress,reviewAddress,recommendationAddress);
        return new ProductAggregateDTO(productId,productName,weight,recommendationSummaries,reviewsSummary,serviceAddresses);
    }
}
