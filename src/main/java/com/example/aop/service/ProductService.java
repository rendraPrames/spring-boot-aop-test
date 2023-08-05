package com.example.aop.service;

import com.example.aop.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    List<Product> getAll();
}
