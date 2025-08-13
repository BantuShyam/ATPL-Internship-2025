package com.aaslin.productapi.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.aaslin.productapi.exception.ProductNotFoundException;
import com.aaslin.productapi.model.Product;

@Service
public class ProductService {
    private final Map<Long, Product> productMap = new HashMap<>();
    private Long idCounter = 1L;

    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    public Product getProductById(Long id) throws ProductNotFoundException {
        Product product = productMap.get(id);
        if (product == null) {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
        return product;
    }

    public Product addProduct(Product product) {
        product.setId(idCounter++);
        productMap.put(product.getId(), product);
        return product;
    }

    public Product updateProduct(Long id, Product updatedProduct) throws ProductNotFoundException {
        if (!productMap.containsKey(id)) {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
        updatedProduct.setId(id);
        productMap.put(id, updatedProduct);
        return updatedProduct;
    }

    public void deleteProduct(Long id) throws ProductNotFoundException {
        if (!productMap.containsKey(id)) {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
        productMap.remove(id);
    }
}


