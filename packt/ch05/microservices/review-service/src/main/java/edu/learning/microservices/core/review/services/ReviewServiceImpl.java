package edu.learning.microservices.core.review.services;

import edu.learning.api.core.review.IReview;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.util.http.ServiceUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReviewServiceImpl implements IReview {

    private static final Logger LOG = LogManager.getLogger(ReviewServiceImpl.class);

    private final ServiceUtility serviceUtil;

    @Autowired
    public ReviewServiceImpl(ServiceUtility serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<ReviewDTO> getReviews(int productId) {

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        if (productId == 213) {
            LOG.debug("No reviews found for productId: {}", productId);
            return new ArrayList<ReviewDTO>();
        }

        List<ReviewDTO> list = new ArrayList<>();
        list.add(new ReviewDTO(productId, 1, "Author 1", "Subject 1", "Content 1", serviceUtil.getServiceAddress()));
        list.add(new ReviewDTO(productId, 2, "Author 2", "Subject 2", "Content 2", serviceUtil.getServiceAddress()));
        list.add(new ReviewDTO(productId, 3, "Author 3", "Subject 3", "Content 3", serviceUtil.getServiceAddress()));

        LOG.debug("/reviews response size: {}", list.size());

        return list;
    }

}
