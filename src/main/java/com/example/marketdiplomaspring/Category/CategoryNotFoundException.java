package com.example.marketdiplomaspring.Category;

public class CategoryNotFoundException extends RuntimeException {
    CategoryNotFoundException(Long id) {
        super("Could not find category " + id);
    }
}
