package edu.learning.microservices.core.recommendation.controller;

import edu.learning.api.core.recommendation.IRecommendation;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationServiceImpl implements IRecommendation {
    private final Logger LOGGER = LogManager.getLogger(RecommendationServiceImpl.class);
    private final ServiceUtil serviceUtil;
    @Autowired
    public RecommendationServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }
    @Override
    public List<RecommendationDTO> getRecommendations(int productId) {
        if(productId<1)
            throw new InvalidInputException("Invalid productId: " + productId);
        if(productId==13)
            throw new NotFoundException("No recommendations found for productId: " + productId);
        List<RecommendationDTO> recommendations = List.of(
                new RecommendationDTO(productId, 1, "Author 1", 1, "Content 1", serviceUtil.getServiceAddress()),
                new RecommendationDTO(productId, 2, "Author 2", 2, "Content 2", serviceUtil.getServiceAddress()),
                new RecommendationDTO(productId, 3, "Author 3", 3, "Content 3", serviceUtil.getServiceAddress())
        );
        LOGGER.info("/recommendation response size: {}", recommendations.size());
        return recommendations;
    }
}
