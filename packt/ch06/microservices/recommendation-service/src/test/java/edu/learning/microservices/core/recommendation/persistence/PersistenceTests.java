package edu.learning.microservices.core.recommendation.persistence;


import edu.learning.microservices.core.recommendation.entity.RecommendationEntity;
import edu.learning.microservices.core.recommendation.repository.RecommendationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.testcontainers.shaded.org.hamcrest.MatcherAssert;
import org.testcontainers.shaded.org.hamcrest.Matchers;
import java.util.List;


@DataMongoTest
public class PersistenceTests extends MongoDbTestBase {

    @Autowired
    private RecommendationRepository recommendationRepository;
    private RecommendationEntity recommendationEntity;

    @BeforeEach
    void setupDb() {
        recommendationRepository.deleteAll();

        RecommendationEntity entity = new RecommendationEntity(1,2, "a", 3,"c");
        recommendationEntity = recommendationRepository.save(entity);

        assertEqualsRecommendation(entity, recommendationEntity);
    }

    @Test
    void create() {

        RecommendationEntity newEntity = new RecommendationEntity(1,3, "a",3, "c");
        recommendationRepository.save(newEntity);

        RecommendationEntity foundEntity = recommendationRepository.findById(newEntity.getId()).get();
        assertEqualsRecommendation(newEntity, foundEntity);

        Assertions.assertEquals(2, recommendationRepository.count());
    }

    @Test
    void update() {
        recommendationEntity.setAuthor("a2");
        recommendationRepository.save(recommendationEntity);

        RecommendationEntity foundEntity = recommendationRepository.findById(recommendationEntity.getId()).get();
        Assertions.assertEquals(1, (long)foundEntity.getVersion());
        Assertions.assertEquals("a2", foundEntity.getAuthor());
    }

    @Test
    void delete() {
        recommendationRepository.delete(recommendationEntity);
        Assertions.assertFalse(recommendationRepository.existsById(recommendationEntity.getId()));
    }
    @Test
    void getByProductId() {
        List<RecommendationEntity> entityList = recommendationRepository.findByProductId(recommendationEntity.getProductId());

        MatcherAssert.assertThat(entityList, Matchers.hasSize(1));
        assertEqualsRecommendation(recommendationEntity, entityList.get(0));
    }

    @Test
    void duplicateError() {
        Assertions.assertThrows(DuplicateKeyException.class, () -> {
            RecommendationEntity entity = new RecommendationEntity(1, 2, "a", 3, "c");
            recommendationRepository.save(entity);
        });
    }


    @Test
    void optimisticLockError() {

        // Store the saved entity in two separate entity objects
        RecommendationEntity entity1 = recommendationRepository.findById(recommendationEntity.getId()).get();
        RecommendationEntity entity2 = recommendationRepository.findById(recommendationEntity.getId()).get();

        // Update the entity using the first entity object
        entity1.setAuthor("a1");
        recommendationRepository.save(entity1);

        // Update the entity using the second entity object.
        // This should fail since the second entity now holds an old version number, i.e. an Optimistic Lock Error
        Assertions.assertThrows(OptimisticLockingFailureException.class, () -> {
            entity2.setAuthor("a2");
            recommendationRepository.save(entity2);
        });

        // Get the updated entity from the database and verify its new sate
        RecommendationEntity updatedEntity = recommendationRepository.findById(recommendationEntity.getId()).get();
        Assertions.assertEquals(1, (int)updatedEntity.getVersion());
        Assertions.assertEquals("a1", updatedEntity.getAuthor());
    }

    private void assertEqualsRecommendation(RecommendationEntity expectedEntity, RecommendationEntity actualEntity) {
        Assertions.assertEquals(expectedEntity.getId(),               actualEntity.getId());
        Assertions.assertEquals(expectedEntity.getVersion(),          actualEntity.getVersion());
        Assertions.assertEquals(expectedEntity.getProductId(),        actualEntity.getProductId());
        Assertions.assertEquals(expectedEntity.getRecommendationId(),           actualEntity.getRecommendationId());
        Assertions.assertEquals(expectedEntity.getAuthor(),           actualEntity.getAuthor());
        Assertions.assertEquals(expectedEntity.getRating(), actualEntity.getRating());
        Assertions.assertEquals(expectedEntity.getContent(),actualEntity.getContent());
    }
}
