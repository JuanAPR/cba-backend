package com.cbaservice.cba_backend.repository;

import com.cbaservice.cba_backend.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    List<Product> findByCategoryId(Long id);
}
