package com.jmachuca.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmachuca.springboot.di.app.springboot_di.models.Product;
import com.jmachuca.springboot.di.app.springboot_di.services.ProductService;

@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private ProductService service;

    @GetMapping("")
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product showProduct(@PathVariable Long id) {
        return service.findById(id);
    }
}
