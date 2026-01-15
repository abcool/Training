package edu.learning.microservices.core.recommendation.service;

import edu.learning.api.core.recommendation.IRecommendation;
import edu.learning.api.core.recommendation.RecommendationDTO;
import edu.learning.api.exceptions.InvalidInputException;
import edu.learning.api.exceptions.NotFoundException;
import edu.learning.microservices.core.recommendation.mapper.RecommendationMapper;
import edu.learning.microservices.core.recommendation.persistence.RecommendationRepository;
import edu.learning.util.http.ServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.*;

@RestController
public class RecommendationService implements IRecommendation {
    private static final Logger log = LogManager.getLogger(RecommendationService.class);
    private final ServiceUtil serviceUtil;
    private final RecommendationRepository recommendationRepository;
    private final RecommendationMapper recommendationMapper;

    @Autowired
    public RecommendationService(ServiceUtil serviceUtil,
                                 RecommendationRepository recommendationRepository,
                                 RecommendationMapper recommendationMapper) {
        this.serviceUtil=serviceUtil;
        this.recommendationRepository=recommendationRepository;
        this.recommendationMapper=recommendationMapper;
    }

    @Override
    public Mono<ResponseEntity<List<RecommendationDTO>>> getRecommendations(int productId) {

        if (productId < 1) {
            return Mono.error(new InvalidInputException("Product id must be greater than zero"));
        }

        return recommendationRepository.findByProductId(productId)
                .collectList()
                .map(recommendationMapper::entityListToDtoList)
                .map(dtoList -> new ResponseEntity<>(dtoList, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(List.of(), HttpStatus.OK));
    }

    /**
     * @param recommendationDTO
     * @return
     */
    @Override
    public Mono<ResponseEntity<RecommendationDTO>> createRecommendation(RecommendationDTO recommendationDTO) {
        log.info("Received DTO: {}", recommendationDTO);  // ✅ Add this debug line
        var recommendationEntity = recommendationMapper.dtoToEntity(recommendationDTO);
        log.info("recommendation entity: {}", recommendationEntity);
        return recommendationRepository.save(recommendationEntity)
                .map(recommendationMapper::entityToDto)
                .map(dto -> new ResponseEntity<>(dto,HttpStatus.CREATED))
                .onErrorMap(DuplicateKeyException.class,ex -> new InvalidInputException("Duplicate key, Recommendation Id:" + recommendationDTO.getRecommendationId()));
    }

    /**
     * @param productId
     * @return
     */
    @Override
    public Mono<ResponseEntity<Void>> deleteRecommendations(int productId) {
        if (productId < 1) {
            return Mono.error(new InvalidInputException("Invalid productId: " + productId));
        }

        return recommendationRepository.deleteByProductId(productId)
                .then(Mono.just(new ResponseEntity<>(HttpStatus.NO_CONTENT)));
    }
}
