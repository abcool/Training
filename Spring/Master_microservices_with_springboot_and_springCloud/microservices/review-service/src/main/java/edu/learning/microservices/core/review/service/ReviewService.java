package edu.learning.microservices.core.review.service;

import edu.learning.api.core.review.IReview;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@RestController
public class ReviewService implements IReview {
    private static final Logger log = LogManager.getLogger(ReviewService.class);

    private final ServiceUtil serviceUtil;

    @Autowired
    public ReviewService(ServiceUtil serviceUtil){
        this.serviceUtil=serviceUtil;
    }

    @Override
    public Mono<ResponseEntity<List<ReviewDTO>>> getReviews(int productId) {
        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        if (productId == 213) {
            log.debug("No reviews found for productId: {}", productId);
            return Mono.just(new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND));
        }
        var reviews = new ArrayList<ReviewDTO>();

        reviews.add(new ReviewDTO(productId, 1, "Author 1", "Subject 1", "Content 1", serviceUtil.getServiceAddress()));
        reviews.add(new ReviewDTO(productId, 2, "Author 2", "Subject 2", "Content 2", serviceUtil.getServiceAddress()));
        reviews.add(new ReviewDTO(productId, 3, "Author 3", "Subject 3", "Content 3", serviceUtil.getServiceAddress()));

        return Mono.just(new ResponseEntity<>(reviews, HttpStatus.OK));
    }
}
