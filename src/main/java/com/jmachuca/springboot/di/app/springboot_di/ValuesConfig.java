package com.jmachuca.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.jmachuca.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.jmachuca.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({
    @PropertySource(value = "classpath:config.properties", encoding = "UTF-8")
})
public class ValuesConfig {

    @Bean // Forma alternativa de crear un componente
    // @Primary
    ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson();
    }
}
