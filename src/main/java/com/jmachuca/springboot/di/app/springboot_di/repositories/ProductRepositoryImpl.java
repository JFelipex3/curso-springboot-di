package com.jmachuca.springboot.di.app.springboot_di.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
//import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;

import com.jmachuca.springboot.di.app.springboot_di.models.Product;

//@RequestScope // Define que cada ejecución es por Request y luego se destruye, en caso de no indicar es Singleton y se actualiza para todos almacenando en memoria
//@SessionScope // Define una session y está se mantendra activa hasta que se cierre. Si se muta el objeto va a cambiar los valores hasta que se cierre.
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = List.of(
            new Product(1L, "Memoria Corsair 32", 300L),
            new Product(2L, "CPU Intel Core i9", 850L),
            new Product(3L, "Teclado Razer Mini 60%", 180L),
            new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    @Override
    public List<Product> findAll() {
        return this.data;
    }

    @Override
    public Product findById(Long id) {
        return this.data.stream()
            .filter(product -> product.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    
}
