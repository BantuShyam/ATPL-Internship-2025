package com.aaslin.productapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aaslin.productapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

