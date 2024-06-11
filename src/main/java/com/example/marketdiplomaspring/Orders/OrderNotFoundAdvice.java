package com.example.marketdiplomaspring.Orders;

import com.example.marketdiplomaspring.Orders.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class OrderNotFoundAdvice {

    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(OrderNotFoundException ex) {
        return ex.getMessage();
    }
}

