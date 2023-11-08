package com.gen.shuncosDB.repository;

import com.gen.shuncosDB.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
