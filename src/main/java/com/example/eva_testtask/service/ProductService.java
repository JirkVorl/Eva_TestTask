package com.example.eva_testtask.service;

import com.example.eva_testtask.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product add(Product product);
}
