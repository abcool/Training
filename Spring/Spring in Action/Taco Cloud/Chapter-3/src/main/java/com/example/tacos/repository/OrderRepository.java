package com.example.tacos.repository;

import com.example.tacos.domain.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<TacoOrder, Long> {
     List<TacoOrder> findByDeliveryZip(String zipCode);
   // TacoOrder saveOrder(TacoOrder order);
}
