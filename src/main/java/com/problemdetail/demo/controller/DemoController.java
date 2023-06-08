package com.problemdetail.demo.controller;

import com.problemdetail.demo.entity.Product;
import com.problemdetail.demo.exception.ProductNotFoundException;
import com.problemdetail.demo.service.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        var result = demoService.getProductById(id);
        if (result.isEmpty()) {
            throw new ProductNotFoundException(id);
        }
        return ResponseEntity.ok(result.get());
    }
}
