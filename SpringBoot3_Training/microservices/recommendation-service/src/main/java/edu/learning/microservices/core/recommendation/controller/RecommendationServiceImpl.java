package edu.learning.microservices.core.recommendation.controller;

import edu.learning.api.core.recommendation.IRecommendation;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.microservices.core.recommendation.persistence.RecommendationEntity;
import edu.learning.microservices.core.recommendation.persistence.RecommendationRepository;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationServiceImpl implements IRecommendation {
    private final Logger LOGGER = LogManager.getLogger(RecommendationServiceImpl.class);

    private final RecommendationRepository repository;

    private final RecommendationMapper mapper;

    private final ServiceUtil serviceUtil;

    @Autowired
    public RecommendationServiceImpl(RecommendationRepository repository, RecommendationMapper mapper, ServiceUtil serviceUtil) {
        this.repository = repository;
        this.mapper = mapper;
        this.serviceUtil = serviceUtil;
    }
    @Override
    public RecommendationDTO createRecommendation(RecommendationDTO body) {
        try {
            RecommendationEntity entity = mapper.apiToEntity(body);
            RecommendationEntity newEntity = repository.save(entity);

            LOGGER.debug("createRecommendation: created a recommendation entity: {}/{}", body.productId(), body.recommendationId());
            return mapper.entityToApi(newEntity);

        } catch (DuplicateKeyException dke) {
            throw new InvalidInputException("Duplicate key, Product Id: " + body.productId() + ", Recommendation Id:" + body.recommendationId());
        }
    }

    @Override
    public List<RecommendationDTO> getRecommendations(int productId) {

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        List<RecommendationEntity> entityList = repository.findByProductId(productId);
        if(entityList.size()<1)
           LOGGER.debug(" No recommendations found for productId: {}", productId);
        List<RecommendationDTO> list = mapper.entityListToApiList(entityList);
        list = list.stream().map(item -> new RecommendationDTO(
                item.productId(),
                item.recommendationId(),
                item.author(),
                item.rate(),
                item.content(),
                serviceUtil.getServiceAddress()))
                .toList();


        LOGGER.debug("getRecommendations: response size: {}", list.size());

        return list;
    }

    @Override
    public void deleteRecommendations(int productId) {
        LOGGER.debug("deleteRecommendations: tries to delete recommendations for the product with productId: {}", productId);
        if(repository.findByProductId(productId).size()<1)
            LOGGER.debug("Nothing to delete for productId: {}", productId);
        repository.deleteAll(repository.findByProductId(productId));
    }
}
