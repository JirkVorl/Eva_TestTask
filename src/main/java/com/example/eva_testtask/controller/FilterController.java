package com.example.eva_testtask.controller;

import com.example.eva_testtask.model.Product;
import com.example.eva_testtask.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FilterController {
    private final ProductService productService;

    public FilterController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/shop/product")
    public List<Product> getFilteredProducts(@RequestParam String nameFilter) {
        List<Product> products = productService.getAll();
        return products.stream()
                .filter(product -> !product.getName().matches(nameFilter))
                .collect(Collectors.toList());
    }
}
