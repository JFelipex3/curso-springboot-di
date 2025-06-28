package com.jmachuca.springboot.di.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.Resource;

import com.jmachuca.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.jmachuca.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({
    @PropertySource(value = "classpath:config.properties", encoding = "UTF-8")
})
public class ValuesConfig {

    // Implementado para indicar resource injectado en componente.
    @Value("classpath:json/product.json")
    private Resource resource;

    @Bean("productJson") // Forma alternativa de crear un componente
    // @Primary
    ProductRepository productRepositoryJson() {
        // Version sin resource
        //return new ProductRepositoryJson();

        // Version indicando resource
        return new ProductRepositoryJson(resource);
    }
}
