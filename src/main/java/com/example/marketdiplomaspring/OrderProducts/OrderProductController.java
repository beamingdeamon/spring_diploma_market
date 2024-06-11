package com.example.marketdiplomaspring.OrderProducts;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/order/product")
public class OrderProductController {

    private final OrderProductRepository orderRepository;


    public OrderProductController(OrderProductRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @GetMapping("")
    public Iterable<OrderProduct> getOrderProducts()
    {
        OrderProductService orderService = new OrderProductService();

        return orderService.getOrderProducts(this.orderRepository);
    }

    @PostMapping("")
    public OrderProduct addOrderProduct(@RequestBody OrderProduct order) {

        OrderProductService orderService = new OrderProductService();

        return orderService.addOrderProduct(this.orderRepository, order);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderProduct(@PathVariable Long id) {

        OrderProductService orderService = new OrderProductService();

        String response = orderService.deleteOrderProduct(this.orderRepository, id);

        return response;
    }
}