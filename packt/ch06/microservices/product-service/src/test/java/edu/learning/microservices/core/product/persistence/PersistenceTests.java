package edu.learning.microservices.core.product.persistence;

import edu.learning.microservices.core.product.entity.ProductEntity;
import edu.learning.microservices.core.product.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@DataMongoTest
public class PersistenceTests extends MongoDbTestBase{

    @Autowired
    private ProductRepository productRepository;
    private ProductEntity productEntity;

    @BeforeEach
    void setupDb() {
        productRepository.deleteAll();

        ProductEntity entity = new ProductEntity(1, "n", 1);
        productEntity = productRepository.save(entity);

        assertEqualsProduct(entity, productEntity);
    }

    @Test
    void create() {

        ProductEntity newEntity = new ProductEntity(2, "n", 2);
        productRepository.save(newEntity);

        ProductEntity foundEntity = productRepository.findById(newEntity.getId()).get();
        assertEqualsProduct(newEntity, foundEntity);

        Assertions.assertEquals(2, productRepository.count());
    }

    @Test
    void update() {
        productEntity.setName("n2");
        productRepository.save(productEntity);

        ProductEntity foundEntity = productRepository.findById(productEntity.getId()).get();
        Assertions.assertEquals(1, (long)foundEntity.getVersion());
        Assertions.assertEquals("n2", foundEntity.getName());
    }

    @Test
    void delete() {
        productRepository.delete(productEntity);
        Assertions.assertFalse(productRepository.existsById(productEntity.getId()));
    }
    @Test
    void getByProductId() {
        Optional<ProductEntity> entity = productRepository.findByProductId(productEntity.getProductId());

        Assertions.assertTrue(entity.isPresent());
        assertEqualsProduct(productEntity, entity.get());
    }

    @Test
    void duplicateError() {
        Assertions.assertThrows(DuplicateKeyException.class, () -> {
            ProductEntity entity = new ProductEntity(productEntity.getProductId(), "n", 1);
            productRepository.save(entity);
        });
    }

    @Test
    void optimisticLockError() {

        // Store the saved entity in two separate entity objects
        ProductEntity entity1 = productRepository.findById(productEntity.getId()).get();
        ProductEntity entity2 = productRepository.findById(productEntity.getId()).get();

        // Update the entity using the first entity object
        entity1.setName("n1");
        productRepository.save(entity1);

        // Update the entity using the second entity object.
        // This should fail since the second entity now holds an old version number, i.e. an Optimistic Lock Error
        Assertions.assertThrows(OptimisticLockingFailureException.class, () -> {
            entity2.setName("n2");
            productRepository.save(entity2);
        });

        // Get the updated entity from the database and verify its new sate
        ProductEntity updatedEntity = productRepository.findById(productEntity.getId()).get();
        Assertions.assertEquals(1, (int)updatedEntity.getVersion());
        Assertions.assertEquals("n1", updatedEntity.getName());
    }
    @Test
    void paging() {

        productRepository.deleteAll();

        List<ProductEntity> newProducts = IntStream.rangeClosed(1001, 1010)
                .mapToObj(i -> new ProductEntity(i, "name " + i, i))
                .collect(Collectors.toList());
        productRepository.saveAll(newProducts);

        Pageable nextPage = PageRequest.of(0, 4, Sort.Direction.ASC, "productId");
        nextPage = testNextPage(nextPage, "[1001, 1002, 1003, 1004]", true);
        nextPage = testNextPage(nextPage, "[1005, 1006, 1007, 1008]", true);
        nextPage = testNextPage(nextPage, "[1009, 1010]", false);
    }

    private Pageable testNextPage(Pageable nextPage, String expectedProductIds, boolean expectsNextPage) {
        Page<ProductEntity> productPage = productRepository.findAll(nextPage);
        Assertions.assertEquals(expectedProductIds, productPage.getContent().stream().map(p -> p.getProductId()).collect(Collectors.toList()).toString());
        Assertions.assertEquals(expectsNextPage, productPage.hasNext());
        return productPage.nextPageable();
    }

    private void assertEqualsProduct(ProductEntity expectedEntity, ProductEntity actualEntity) {
        Assertions.assertEquals(expectedEntity.getId(),               actualEntity.getId());
        Assertions.assertEquals(expectedEntity.getVersion(),          actualEntity.getVersion());
        Assertions.assertEquals(expectedEntity.getProductId(),        actualEntity.getProductId());
        Assertions.assertEquals(expectedEntity.getName(),           actualEntity.getName());
        Assertions.assertEquals(expectedEntity.getWeight(),           actualEntity.getWeight());
    }
}
