package edu.learning.microservices.core.review.controller;

import edu.learning.api.core.review.IReview;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.microservices.core.review.persistence.ReviewEntity;
import edu.learning.microservices.core.review.persistence.ReviewRepository;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewServiceImpl implements IReview {
    private final Logger LOGGER = LogManager.getLogger(ReviewServiceImpl.class);
    private final ReviewRepository repository;

    private final ReviewMapper mapper;

    private final ServiceUtil serviceUtil;

    @Autowired
    public ReviewServiceImpl(ReviewRepository repository, ReviewMapper mapper, ServiceUtil serviceUtil) {
        this.repository = repository;
        this.mapper = mapper;
        this.serviceUtil = serviceUtil;
    }

    @Override
    public ReviewDTO createReview(ReviewDTO body) {
        try {
            ReviewEntity entity = mapper.dtoToEntity(body);
            ReviewEntity newEntity = repository.save(entity);

            LOGGER.debug("createReview: created a review entity: {}/{}", body.productId(), body.reviewId());
            return mapper.entityToDto(newEntity);

        } catch (DataIntegrityViolationException dive) {
            throw new InvalidInputException("Duplicate key, Product Id: " + body.productId() + ", Review Id:" + body.reviewId());
        }
    }
    @Override
    public List<ReviewDTO> getReviews(int productId) {
        if(productId<1)
            throw new InvalidInputException("Invalid productId: " + productId);
        if(productId == 213)
            throw new NotFoundException("No reviews found for productId: " + productId);
        List<ReviewEntity> entityList = repository.findByProductId(productId);
        List<ReviewDTO> list = mapper.entityListToDtoList(entityList);
        list = list.stream().map(item -> new ReviewDTO(
                item.productId(),
                item.reviewId(),
                item.author(),
                item.subject(),
                item.content(),
                serviceUtil.getServiceAddress()
                ))
                .toList();

        LOGGER.debug("getReviews: response size: {}", list.size());

        return list;
    }
    @Override
    public void deleteReviews(int productId) {
        LOGGER.debug("deleteReviews: tries to delete reviews for the product with productId: {}", productId);
        repository.deleteAll(repository.findByProductId(productId));
    }
}
