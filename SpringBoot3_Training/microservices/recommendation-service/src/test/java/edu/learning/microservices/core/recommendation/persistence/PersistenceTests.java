package edu.learning.microservices.core.recommendation.persistence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.OptimisticLockingFailureException;
import edu.learning.microservices.core.recommendation.persistence.RecommendationEntity;
import edu.learning.microservices.core.recommendation.persistence.RecommendationRepository;

@DataMongoTest
class PersistenceTests extends MongoDbTestBase {

    @Autowired
    private RecommendationRepository repository;

    private RecommendationEntity savedEntity;

    @BeforeEach
    void setupDb() {
        repository.deleteAll();

        RecommendationEntity entity = new RecommendationEntity(1, 2, "a", 3, "c");
        savedEntity = repository.save(entity);

        assertEqualsRecommendation(entity, savedEntity);
    }


    @Test
    void create() {

        RecommendationEntity newEntity = new RecommendationEntity(1, 3, "a", 3, "c");
        repository.save(newEntity);

        RecommendationEntity foundEntity = repository.findById(newEntity.getId()).get();
        assertEqualsRecommendation(newEntity, foundEntity);

        assertEquals(2, repository.count());
    }

    @Test
    void update() {
        savedEntity.setAuthor("a2");
        repository.save(savedEntity);

        RecommendationEntity foundEntity = repository.findById(savedEntity.getId()).get();
        assertEquals(1, (long)foundEntity.getVersion());
        assertEquals("a2", foundEntity.getAuthor());
    }

    @Test
    void delete() {
        repository.delete(savedEntity);
        assertFalse(repository.existsById(savedEntity.getId()));
    }

    @Test
    void getByProductId() {
        List<RecommendationEntity> entityList = repository.findByProductId(savedEntity.getProductId());

        assertThat(entityList, hasSize(1));
        assertEqualsRecommendation(savedEntity, entityList.get(0));
    }

    @Test
    void duplicateError() {
        assertThrows(DuplicateKeyException.class, () -> {
            RecommendationEntity entity = new RecommendationEntity(1, 2, "a", 3, "c");
            repository.save(entity);
        });
    }

    @Test
    void optimisticLockError() {

        // Store the saved entity in two separate entity objects
        RecommendationEntity entity1 = repository.findById(savedEntity.getId()).get();
        RecommendationEntity entity2 = repository.findById(savedEntity.getId()).get();

        // Update the entity using the first entity object
        entity1.setAuthor("a1");
        repository.save(entity1);

        //  Update the entity using the second entity object.
        // This should fail since the second entity now holds an old version number, i.e. an Optimistic Lock Error
        assertThrows(OptimisticLockingFailureException.class, () -> {
            entity2.setAuthor("a2");
            repository.save(entity2);
        });

        // Get the updated entity from the database and verify its new sate
        RecommendationEntity updatedEntity = repository.findById(savedEntity.getId()).get();
        assertEquals(1, (int)updatedEntity.getVersion());
        assertEquals("a1", updatedEntity.getAuthor());
    }

    private void assertEqualsRecommendation(RecommendationEntity expectedEntity, RecommendationEntity actualEntity) {
        assertEquals(expectedEntity.getId(),               actualEntity.getId());
        assertEquals(expectedEntity.getVersion(),          actualEntity.getVersion());
        assertEquals(expectedEntity.getProductId(),        actualEntity.getProductId());
        assertEquals(expectedEntity.getRecommendationId(), actualEntity.getRecommendationId());
        assertEquals(expectedEntity.getAuthor(),           actualEntity.getAuthor());
        assertEquals(expectedEntity.getRating(),           actualEntity.getRating());
        assertEquals(expectedEntity.getContent(),          actualEntity.getContent());
    }
}
