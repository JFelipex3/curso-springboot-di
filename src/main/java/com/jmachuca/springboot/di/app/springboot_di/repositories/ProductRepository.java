package com.jmachuca.springboot.di.app.springboot_di.repositories;

import java.util.List;

import com.jmachuca.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = List.of(
            new Product(1L, "Memoria Corsair 32", 300L),
            new Product(2L, "CPU Intel Core i9", 850L),
            new Product(3L, "Teclado Razer Mini 60%", 180L),
            new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    public List<Product> findAll() {
        return this.data;
    }

    public Product findById(Long id) {
        return this.data.stream()
            .filter(product -> product.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    
}
