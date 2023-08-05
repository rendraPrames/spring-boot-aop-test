package com.example.aop.aspect;

import com.example.aop.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.example.aop.service.ProductService.addProduct(..)) && args(product)")
    public void logBeforeAddProduct(JoinPoint joinPoint, Product product) {
        if (product == null) {
            log.info("Trying to add a null product.");
            throw new IllegalArgumentException("Product cannot be null.");
        }

        if (product.getName() == null || product.getName().isEmpty()) {
            log.info("Trying to add a product with null or empty name.");
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }

        if (product.getPrice() == null || product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            log.info("Trying to add a product with null or negative price.");
            throw new IllegalArgumentException("Product price cannot be null or negative.");
        }

        log.info("Before Adding Product: " + product.getName() + " with Price: " + product.getPrice());
    }

    @AfterReturning("execution(* com.example.aop.service.ProductService.addProduct(..)) && args(product)")
    public void logAfterAddProduct(JoinPoint joinPoint, Product product) {
        log.info("After Adding Product: " + product.getName() + " with Price: " + product.getPrice());
    }
}