package edu.learning.microservices.core.review.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReviewRepository extends ReactiveCrudRepository<ReviewEntity, Integer> {

    @Transactional(readOnly = true)
    Flux<ReviewEntity> findByProductId(int productId);

    Mono<Void> deleteByProductId(int productId);


}
