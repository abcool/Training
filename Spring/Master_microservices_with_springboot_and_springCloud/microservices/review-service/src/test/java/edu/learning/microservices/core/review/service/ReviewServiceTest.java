package edu.learning.microservices.core.review.service;

import edu.learning.microservices.core.review.config.MySqlTestConfig;
import edu.learning.microservices.core.review.persistence.ReviewEntity;
import edu.learning.microservices.core.review.persistence.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import reactor.test.StepVerifier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

@DataR2dbcTest
@Import(MySqlTestConfig.class)
public class ReviewServiceTest {

    @Autowired
    private ReviewRepository repository;

    private ReviewEntity savedEntity;

    @BeforeEach
    void setupDb() {
        repository.deleteAll().block();

        // Don't set version - let R2DBC handle it
        ReviewEntity entity = new ReviewEntity();
        entity.setProductId(2);
        entity.setReviewId(1);
        entity.setAuthor("a");
        entity.setSubject("s");
        entity.setContent("c");

        savedEntity = repository.save(entity).block();

        assertNotNull(savedEntity);
        assertNotNull(savedEntity.getId());
        assertEquals(0, savedEntity.getVersion());
    }

    @Test
    void create() {
        // Don't set id - let database auto-generate it
        ReviewEntity newEntity = new ReviewEntity();
        newEntity.setProductId(3);
        newEntity.setReviewId(1);
        newEntity.setAuthor("a");
        newEntity.setSubject("s");
        newEntity.setContent("c");

        ReviewEntity saved = repository.save(newEntity).block();

        assertNotNull(saved);
        assertNotNull(saved.getId());

        ReviewEntity foundEntity = repository.findById(saved.getId()).block();
        assertNotNull(foundEntity);
        assertEqualsReview(saved, foundEntity);

        Long count = repository.count().block();
        assertEquals(2L, count);  // Now this should pass
    }


    @Test
    void update() {
        savedEntity.setAuthor("a2");
        repository.save(savedEntity).block();

        ReviewEntity foundEntity = repository.findById(savedEntity.getId()).block();
        assertNotNull(foundEntity);
        assertEquals(1, foundEntity.getVersion());
        assertEquals("a2", foundEntity.getAuthor());
    }

    @Test
    void delete() {
        repository.delete(savedEntity).block();

        Boolean exists = repository.existsById(savedEntity.getId()).block();
        assertFalse(exists);
    }

    @Test
    void getByProductId() {
        StepVerifier.create(repository.findByProductId(savedEntity.getProductId())
                        .collectList())
                .assertNext(entityList -> {
                    assertThat(entityList, hasSize(1));
                    assertEqualsReview(savedEntity, entityList.get(0));
                })
                .verifyComplete();
    }

    @Test
    void duplicateError() {
        ReviewEntity entity = new ReviewEntity();
        entity.setProductId(2);   // Same as savedEntity
        entity.setReviewId(1);    // Same as savedEntity
        entity.setAuthor("a");
        entity.setSubject("s");
        entity.setContent("c");

        StepVerifier.create(repository.save(entity))
                .expectError(DataIntegrityViolationException.class)
                .verify();
    }


    @Test
    void optimisticLockError() {
        // Fetch the same entity twice
        ReviewEntity entity1 = repository.findById(savedEntity.getId()).block();
        ReviewEntity entity2 = repository.findById(savedEntity.getId()).block();

        // Update using first entity
        entity1.setAuthor("a1");
        repository.save(entity1).block();

        // Try to update using second entity (stale version)
        entity2.setAuthor("a2");

        StepVerifier.create(repository.save(entity2))
                .expectError(OptimisticLockingFailureException.class)
                .verify();

        // Verify final state
        ReviewEntity updatedEntity = repository.findById(savedEntity.getId()).block();
        assertEquals(1, updatedEntity.getVersion());
        assertEquals("a1", updatedEntity.getAuthor());
    }

    private void assertEqualsReview(ReviewEntity expectedEntity, ReviewEntity actualEntity) {
        assertEquals(expectedEntity.getId(), actualEntity.getId());
        assertEquals(expectedEntity.getVersion(), actualEntity.getVersion());
        assertEquals(expectedEntity.getProductId(), actualEntity.getProductId());
        assertEquals(expectedEntity.getReviewId(), actualEntity.getReviewId());
        assertEquals(expectedEntity.getAuthor(), actualEntity.getAuthor());
        assertEquals(expectedEntity.getSubject(), actualEntity.getSubject());
        assertEquals(expectedEntity.getContent(), actualEntity.getContent());
    }
}