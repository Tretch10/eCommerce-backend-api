package com.ecommerce.backendapi.repository;

import com.ecommerce.backendapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
