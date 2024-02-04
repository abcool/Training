package com.example.tacos.repository;

import com.example.tacos.domain.TacoOrder;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface OrderRepository extends CassandraRepository<TacoOrder, Long> {
     List<TacoOrder> findByDeliveryZip(String zipCode);
   // TacoOrder saveOrder(TacoOrder order);
}
