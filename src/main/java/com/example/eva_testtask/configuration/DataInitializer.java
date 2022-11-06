package com.example.eva_testtask.configuration;

import com.example.eva_testtask.model.Product;
import com.example.eva_testtask.service.ProductService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final ProductService productService;

    public DataInitializer(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void inject() {
        Product product1 = new Product("product1", "description");
        Product product2 = new Product("prod2", "description");
        Product product3 = new Product("prod3eva", "description");
        Product product4 = new Product("Eprod4", "description");
        productService.add(product1);
        productService.add(product2);
        productService.add(product3);
        productService.add(product4);
    }
}
