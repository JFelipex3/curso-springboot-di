package com.jmachuca.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmachuca.springboot.di.app.springboot_di.models.Product;
import com.jmachuca.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
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
    
    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
