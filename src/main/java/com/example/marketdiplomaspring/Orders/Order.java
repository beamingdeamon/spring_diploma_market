package com.example.marketdiplomaspring.Orders;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    private @Id
    @GeneratedValue Long id;

    private String name;

    private String address;

    private String phone;

    private String comments;

    private String order_price;

    @CreationTimestamp
    private Date created_at;

    private Order() {}

    private Order(String name, String address, String phone, String comments, String order_price) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.comments = comments;
        this.order_price = order_price;
        this.created_at = new Date();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
