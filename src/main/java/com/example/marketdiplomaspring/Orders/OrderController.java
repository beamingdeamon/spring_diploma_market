package com.example.marketdiplomaspring.Orders;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderRepository orderRepository;


    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @GetMapping("")
    public Iterable<Order> getOrders()
    {
        OrderService orderService = new OrderService();

        return orderService.getOrders(this.orderRepository);
    }

    @PostMapping("")
    public Order addNewOrder(@RequestBody Order order) {

        OrderService orderService = new OrderService();

        return orderService.addOrder(this.orderRepository, order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@RequestBody Order order,  @PathVariable Long id) {

        OrderService orderService = new OrderService();

        return orderService.updateOrder(this.orderRepository,order, id);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderById(@PathVariable Long id) {

        OrderService orderService = new OrderService();

        String response = orderService.deleteOrder(this.orderRepository, id);

        return response;
    }
}