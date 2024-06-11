package com.example.marketdiplomaspring.Orders;

public class OrderNotFoundException extends RuntimeException {
    OrderNotFoundException(Long id) {
        super("Could not find category " + id);
    }
}