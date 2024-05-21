package edu.learning.microservices.core.recommendation.services;

import edu.learning.api.core.recommendation.IRecommendation;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.util.http.ServiceUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class RecommendationServiceImpl implements IRecommendation {
    private static final Logger LOG = LogManager.getLogger(RecommendationServiceImpl.class);

    private final ServiceUtility serviceUtil;

    @Autowired
    public RecommendationServiceImpl(ServiceUtility serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<RecommendationDTO> getRecommendations(int productId) {

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        if (productId == 113) {
            LOG.debug("No recommendations found for productId: {}", productId);
            return new ArrayList<RecommendationDTO>();
        }

        List<RecommendationDTO> list = new ArrayList<>();
        list.add(new RecommendationDTO(productId, 1, "Author 1", 1, "Content 1", serviceUtil.getServiceAddress()));
        list.add(new RecommendationDTO(productId, 2, "Author 2", 2, "Content 2", serviceUtil.getServiceAddress()));
        list.add(new RecommendationDTO(productId, 3, "Author 3", 3, "Content 3", serviceUtil.getServiceAddress()));

        LOG.debug("/recommendation response size: {}", list.size());

        return list;
    }

}
