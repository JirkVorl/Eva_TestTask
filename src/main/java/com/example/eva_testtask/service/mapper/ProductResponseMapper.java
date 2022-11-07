package com.example.eva_testtask.service.mapper;

import com.example.eva_testtask.dto.ProductResponseDto;
import com.example.eva_testtask.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseMapper {
    public ProductResponseDto modelToDto(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        responseDto.setDescription(product.getDescription());
        return responseDto;
    }
}
