package com.example.eva_testtask.service.impl;

import com.example.eva_testtask.dao.ProductDao;
import com.example.eva_testtask.model.Product;
import com.example.eva_testtask.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product add(Product product) {
        return productDao.add(product);
    }
}
