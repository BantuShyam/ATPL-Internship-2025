package com.aaslin.productapi.controller;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.aaslin.productapi.exception.ProductNotFoundException;
import com.aaslin.productapi.model.Product;
import com.aaslin.productapi.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        productService.deleteProduct(id);
    }
}

