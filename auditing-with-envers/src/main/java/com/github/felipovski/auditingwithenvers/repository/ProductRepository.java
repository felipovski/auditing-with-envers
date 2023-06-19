package com.github.felipovski.auditingwithenvers.repository;

import com.github.felipovski.auditingwithenvers.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
