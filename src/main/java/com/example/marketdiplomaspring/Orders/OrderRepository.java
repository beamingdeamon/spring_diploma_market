package com.example.marketdiplomaspring.Orders;

import com.example.marketdiplomaspring.Orders.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
