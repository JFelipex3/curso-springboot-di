package com.jmachuca.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.jmachuca.springboot.di.app.springboot_di.models.Product;
import com.jmachuca.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    //@Autowired
    //@Qualifier("productFoo") // Si no se indica inyecta el Primary
    private ProductRepository repository;

    private Environment environment;

    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository, Environment environment) {
        this.repository = repository;
        this.environment = environment;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream()
            .map(p -> {
                Double priceImpuesto = p.getPrice() * environment.getProperty("config.valorImpuesto", Double.class);
                Double priceTotal = p.getPrice() + priceImpuesto;

                Product newProduct = (Product) p.clone(); // Se aplica clone para no mutar el objeto original
                newProduct.setPrice(priceTotal.longValue());

                return newProduct;

                // p.setPrice(priceTotal.longValue());

                // return p;

            }).collect(Collectors.toList());
    }
    
    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
