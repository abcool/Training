package edu.learning.microservices.core.recommendation.controller;

import edu.learning.api.core.recommendation.IRecommendation;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.util.http.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationServiceImpl implements IRecommendation {
    private final ServiceUtil serviceUtil;
    @Autowired
    public RecommendationServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }
    @Override
    public List<RecommendationDTO> getRecommendations(int productId) {
        List<RecommendationDTO> recommendations = List.of(
                new RecommendationDTO(productId, 1, "Author 1", 1, "Content 1", serviceUtil.getServiceAddress()),
                new RecommendationDTO(productId, 2, "Author 2", 2, "Content 2", serviceUtil.getServiceAddress()),
                new RecommendationDTO(productId, 3, "Author 3", 3, "Content 3", serviceUtil.getServiceAddress())
        );
        return recommendations;
    }
}
