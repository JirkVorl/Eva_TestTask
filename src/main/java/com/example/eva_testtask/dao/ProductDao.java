package com.example.eva_testtask.dao;

import com.example.eva_testtask.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    Product add(Product product);

    List<Product> getAll();
}
