package com.example.tacos.repository;

import com.example.tacos.domain.TacoOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<TacoOrder, Long> {
     List<TacoOrder> findByDeliveryZip(String zipCode);
   // TacoOrder saveOrder(TacoOrder order);
}
