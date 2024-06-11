package com.example.marketdiplomaspring.Orders;

import com.example.marketdiplomaspring.Orders.Order;
import com.example.marketdiplomaspring.Orders.OrderRepository;

public class OrderService {

    public Iterable<Order> getOrders(OrderRepository orderRepository) {
        return orderRepository.findAll();
    }

    public Order addOrder(OrderRepository orderRepository, Order order) {

        return orderRepository.save(order);
    }

    public Order updateOrder(OrderRepository orderRepository, Order new_order, Long id) {

        return orderRepository.findById(id)
                .map(order -> {
                    order.setName(new_order.getName());
                    return orderRepository.save(order);
                })
                .orElseGet(() -> {
                    new_order.setId(id);
                    return orderRepository.save(new_order);
                });
    }

    public String deleteOrder(OrderRepository orderRepository, Long id) {
        Object finded_order = orderRepository.findById(id);
        if (finded_order != null) {
            orderRepository.deleteById(id);
            return "Order deleted";
        }else {
            return "Order not found";
        }



    }
}