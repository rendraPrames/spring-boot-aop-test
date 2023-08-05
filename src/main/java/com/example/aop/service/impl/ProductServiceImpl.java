package com.example.aop.service.impl;

import com.example.aop.model.Product;
import com.example.aop.repository.ProductRepository;
import com.example.aop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
//        if (product == null || product.getName() == null || product.getPrice() == null) {
//            throw new IllegalArgumentException("Product cannot be null and must have name and price");
//        }

        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}