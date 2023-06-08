package com.problemdetail.demo.service;

import com.problemdetail.demo.entity.Product;
import com.problemdetail.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DemoService {

    private final ProductRepository productRepository;

    public DemoService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
