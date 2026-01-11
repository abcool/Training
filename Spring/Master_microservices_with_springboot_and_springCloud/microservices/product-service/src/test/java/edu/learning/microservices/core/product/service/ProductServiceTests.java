package edu.learning.microservices.core.product.service;

import edu.learning.microservices.core.product.config.MongoTestConfig;
import edu.learning.microservices.core.product.persistence.ProductEntity;
import edu.learning.microservices.core.product.persistence.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.rangeClosed;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.Sort.Direction.ASC;

@DataMongoTest
@Import(MongoTestConfig.class)
class ProductServiceTests {

    @Autowired
    private ProductRepository repository;

    private ProductEntity savedEntity;

    @BeforeEach
    void setupDb() {
        repository.deleteAll().block();
        ProductEntity entity = new ProductEntity(1, "n", 1);
        savedEntity = repository.save(entity).block();

        assertNotNull(savedEntity);
        assertEquals(entity.getProductId(), savedEntity.getProductId());
        assertEquals(0, (int) savedEntity.getVersion()); // First save = version 0
    }


    @Test
    void create() {

        ProductEntity newEntity = new ProductEntity(2, "n", 2);
        ProductEntity savedNew = repository.save(newEntity).block(); // ✅ Add .block()

        assertNotNull(savedNew);
        ProductEntity foundEntity = repository.findByProductId(newEntity.getProductId()).block();

        assertNotNull(foundEntity);
        assertEquals(newEntity.getProductId(), foundEntity.getProductId());
        assertEquals(newEntity.getName(), foundEntity.getName());
        assertEquals(newEntity.getWeight(), foundEntity.getWeight());
        assertEquals(2L, repository.count().block()); // ✅ Add .block()
    }

    @Test
    void update() {
        savedEntity.setName("n2");
        repository.save(savedEntity).block(); // ✅ Add .block()

        ProductEntity foundEntity = repository.findByProductId(savedEntity.getProductId()).block();

        assertNotNull(foundEntity);
        assertEquals(1, (int) foundEntity.getVersion()); // ✅ Version increments to 1
        assertEquals("n2", foundEntity.getName());
    }

    @Test
    void delete() {
        repository.delete(savedEntity).block(); // ✅ Add .block()
        assertFalse(repository.existsByProductId(savedEntity.getProductId()).block());
    }

    @Test
    void getByProductId() {
        Mono<ProductEntity> entity = repository.findByProductId(savedEntity.getProductId());

        assertTrue(entity.blockOptional().isPresent());

        ProductEntity found = entity.block();
        assertEquals(savedEntity.getProductId(), found.getProductId());
        assertEquals(savedEntity.getName(), found.getName());
    }

    @Test
    void duplicateError() {
        assertThrows(DuplicateKeyException.class, () -> {
            ProductEntity entity = new ProductEntity(savedEntity.getProductId(), "n", 1);
            repository.save(entity).block(); // ✅ Add .block() to trigger error
        });
    }

    @Test
    void optimisticLockError() {

        // Store the saved entity in two separate entity objects
        ProductEntity entity1 = repository.findByProductId(savedEntity.getProductId()).block();
        ProductEntity entity2 = repository.findByProductId(savedEntity.getProductId()).block();

        // Update the entity using the first entity object
        entity1.setName("n1");
        repository.save(entity1).block(); // ✅ Add .block()

        // Update the entity using the second entity object.
        // This should fail since the second entity now holds an old version number, i.e. an Optimistic Lock Error
        assertThrows(OptimisticLockingFailureException.class, () -> {
            entity2.setName("n2");
            repository.save(entity2).block(); // ✅ Add .block()
        });

        // Get the updated entity from the database and verify its new sate
        ProductEntity updatedEntity = repository.findByProductId(savedEntity.getProductId()).block();
        assertEquals(1, (int)updatedEntity.getVersion());
        assertEquals("n1", updatedEntity.getName());
    }

    @Test
    void paging() {
        repository.deleteAll().block();

        List<ProductEntity> newProducts = rangeClosed(1001, 1010)
                .mapToObj(i -> new ProductEntity(i, "name " + i, i))
                .collect(Collectors.toList());
        repository.saveAll(newProducts).blockLast();

        // Test page 1: items 0-3
        Pageable page1 = PageRequest.of(0, 4, ASC, "productId");
        List<String> result1 = repository.findAllByProductIdNotNull(page1)
                .map(p -> String.valueOf(p.getProductId()))
                .collectList()
                .block();
        assertEquals("[1001, 1002, 1003, 1004]", result1.toString());

        // Test page 2: items 4-7
        Pageable page2 = PageRequest.of(1, 4, ASC, "productId");
        List<String> result2 = repository.findAllByProductIdNotNull(page2)
                .map(p -> String.valueOf(p.getProductId()))
                .collectList()
                .block();
        assertEquals("[1005, 1006, 1007, 1008]", result2.toString());

        // Test page 3: items 8-9 (last page)
        Pageable page3 = PageRequest.of(2, 4, ASC, "productId");
        List<String> result3 = repository.findAllByProductIdNotNull(page3)
                .map(p -> String.valueOf(p.getProductId()))
                .collectList()
                .block();
        assertEquals("[1009, 1010]", result3.toString());
    }
}