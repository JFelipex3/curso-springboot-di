package com.jmachuca.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.jmachuca.springboot.di.app.springboot_di.models.Product;
import com.jmachuca.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        return repository.findAll().stream()
            .map(p -> {
                Double priceImpuesto = p.getPrice() * 0.19;
                Double priceTotal = p.getPrice() + priceImpuesto;

                Product newProduct = (Product) p.clone(); // Se aplica clone para no mutar el objeto original
                newProduct.setPrice(priceTotal.longValue());

                return newProduct;

            }).collect(Collectors.toList());
    }
    
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
