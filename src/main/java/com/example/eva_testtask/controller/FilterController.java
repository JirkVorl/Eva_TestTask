package com.example.eva_testtask.controller;

import com.example.eva_testtask.dto.ProductResponseDto;
import com.example.eva_testtask.model.Product;
import com.example.eva_testtask.service.ProductService;
import com.example.eva_testtask.service.mapper.ProductResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FilterController {
    private final ProductService productService;
    private final ProductResponseMapper mapper;

    public FilterController(ProductService productService, ProductResponseMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping("/shop/product")
    public List<ProductResponseDto> getFilteredProducts(@RequestParam String nameFilter) {
        List<Product> products = productService.getAll();
        return products.parallelStream()
                .filter(product -> !product.getName().matches(nameFilter))
                .map(mapper::modelToDto)
                .collect(Collectors.toList());
    }
}
