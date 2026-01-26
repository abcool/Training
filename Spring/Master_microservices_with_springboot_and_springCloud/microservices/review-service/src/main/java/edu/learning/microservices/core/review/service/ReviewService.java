package edu.learning.microservices.core.review.service;

import edu.learning.api.core.review.IReview;
import edu.learning.api.core.review.ReviewDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.microservices.core.review.mapper.ReviewMapper;
import edu.learning.microservices.core.review.persistence.ReviewRepository;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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

    private final ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;

    @Autowired
    public ReviewService(ServiceUtil serviceUtil,
                         ReviewRepository reviewRepository,
                         ReviewMapper reviewMapper) {
        this.serviceUtil=serviceUtil;
        this.reviewRepository=reviewRepository;
        this.reviewMapper=reviewMapper;
    }

    /**
     * @param reviewDTO
     * @return
     */
    @Override
    public Mono<ResponseEntity<ReviewDTO>> createReview(ReviewDTO reviewDTO) {
        log.info("Received DTO: {}", reviewDTO);  // ✅ Add this debug line
        var reviewEntity = reviewMapper.dtoToEntity(reviewDTO);
        log.info("review entity: {}", reviewEntity);
        return reviewRepository.save(reviewEntity)
                .map(reviewMapper::entityToDto)
                .map(dto -> new ResponseEntity<>(dto,HttpStatus.CREATED))
                .onErrorMap(DuplicateKeyException.class, ex -> new InvalidInputException("Duplicate key, Review Id:" + reviewDTO.getReviewId()));
    }

    @Override
    public Mono<ResponseEntity<List<ReviewDTO>>> getReviews(int productId) {
        if (productId < 1) {
            return Mono.error(new InvalidInputException("Invalid productId: " + productId));
        }

        return reviewRepository.findByProductId(productId)
                .collectList()
                .map(reviewMapper::entityListToDtoList)
                .map(dtoList -> new ResponseEntity<>(dtoList, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(List.of(), HttpStatus.OK));
    }

    /**
     * @param productId
     * @return
     */
    @Override
    public Mono<ResponseEntity<Void>> deleteReviews(int productId) {

        if (productId < 1) {
            return Mono.error(new InvalidInputException("Invalid productId: " + productId));
        }
        return reviewRepository.deleteByProductId(productId)
                .then(Mono.just(new ResponseEntity<>(HttpStatus.NO_CONTENT)));
    }
}
