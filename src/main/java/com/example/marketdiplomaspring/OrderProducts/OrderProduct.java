package com.example.marketdiplomaspring.OrderProducts;

import jakarta.persistence.*;

@Entity
@Table(name = "order_products")
public class OrderProduct {
    private @Id
    @GeneratedValue Long id;

    private Long product_id;

    private Long order_id;

    private OrderProduct() {}

    public Long getId() {
        return this.id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }
}
