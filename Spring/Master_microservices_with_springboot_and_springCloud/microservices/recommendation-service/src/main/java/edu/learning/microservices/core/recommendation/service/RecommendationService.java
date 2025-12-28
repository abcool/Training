package edu.learning.microservices.core.recommendation.service;

import edu.learning.api.core.recommendation.IRecommendation;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RecommendationService implements IRecommendation {
    private static final Logger log = LogManager.getLogger(RecommendationService.class);
    private final ServiceUtil serviceUtil;

    @Autowired
    public RecommendationService(ServiceUtil serviceUtil){
        this.serviceUtil=serviceUtil;
    }

    @Override
    public ResponseEntity<List<RecommendationDTO>> getRecommendations(int productId) {

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        if (productId == 113) {
            log.debug("No recommendations found for productId: {}", productId);
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }

        var recommendations = new ArrayList<RecommendationDTO>();

        recommendations.add(new RecommendationDTO(productId, 1, "Author 1", 1, "Content 1", serviceUtil.getServiceAddress()));
        recommendations.add(new RecommendationDTO(productId, 2, "Author 2", 2, "Content 2", serviceUtil.getServiceAddress()));
        recommendations.add(new RecommendationDTO(productId, 3, "Author 3", 3, "Content 3", serviceUtil.getServiceAddress()));

        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }
}
