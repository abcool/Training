package edu.learning.microservices.core.product.repository;

import edu.learning.microservices.core.product.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<ProductEntity,String>, CrudRepository<ProductEntity,String> {

   Optional<ProductEntity> findByProductId(int productId);

   void deleteAll();
}
