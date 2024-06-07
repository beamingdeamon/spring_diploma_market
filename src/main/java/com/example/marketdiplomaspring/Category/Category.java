package com.example.marketdiplomaspring.Category;

import jakarta.persistence.*;


@Entity
@Table(name = "categories")
public class Category {
    private @Id
    @GeneratedValue Long id;

    private String name;

    private Category() {}

    public Category(String name) {
        this.name = name;
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

}
