package edu.learning.microservices.core.product.persistence;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductEntity,String> {
    Mono<ProductEntity> findByProductId(int productId);

    Mono<Void> deleteByProductId(int productId);

    Mono<Boolean> existsByProductId(int productId);

    // Reactive pagination - returns Flux instead of Page
    Flux<ProductEntity> findAllByProductIdNotNull(Pageable pageable);
}
