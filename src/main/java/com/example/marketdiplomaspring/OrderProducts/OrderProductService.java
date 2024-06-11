package com.example.marketdiplomaspring.OrderProducts;

import com.example.marketdiplomaspring.OrderProducts.OrderProduct;
import com.example.marketdiplomaspring.OrderProducts.OrderProductRepository;

public class OrderProductService {

    public Iterable<OrderProduct> getOrderProducts(OrderProductRepository orderRepository) {
        return orderRepository.findAll();
    }

    public OrderProduct addOrderProduct(OrderProductRepository orderRepository, OrderProduct order) {

        return orderRepository.save(order);
    }


    public String deleteOrderProduct(OrderProductRepository orderRepository, Long id) {
        Object finded_order = orderRepository.findById(id);
        if (finded_order != null) {
            orderRepository.deleteById(id);
            return "OrderProduct deleted";
        }else {
            return "OrderProduct not found";
        }



    }
}