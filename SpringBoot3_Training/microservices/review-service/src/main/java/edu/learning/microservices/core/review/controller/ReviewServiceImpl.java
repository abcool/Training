package edu.learning.microservices.core.review.controller;

import edu.learning.api.core.review.IReview;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewServiceImpl implements IReview {
    private final Logger LOGGER = LogManager.getLogger(ReviewServiceImpl.class);
    private final ServiceUtil serviceUtil;
    @Autowired
    public ReviewServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }
    @Override
    public List<ReviewDTO> getReviews(int productId) {
        if(productId<1)
            throw new InvalidInputException("Invalid productId: " + productId);
        if(productId == 213)
            throw new NotFoundException("No reviews found for productId: " + productId);
        List<ReviewDTO> reviews = List.of(
                new ReviewDTO(productId, 1, "Author 1", "Subject 1", "Content 1", serviceUtil.getServiceAddress()),
                new ReviewDTO(productId, 2, "Author 2", "Subject 2", "Content 2", serviceUtil.getServiceAddress()),
                new ReviewDTO(productId, 3, "Author 3", "Subject 3", "Content 3", serviceUtil.getServiceAddress())

        );
        LOGGER.info("/review response size: {}", reviews.size());
        return reviews;
    }
}
