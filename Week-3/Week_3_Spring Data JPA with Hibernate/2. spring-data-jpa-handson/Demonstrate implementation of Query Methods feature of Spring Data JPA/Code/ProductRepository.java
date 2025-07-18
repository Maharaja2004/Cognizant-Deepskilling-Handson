package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // 1. Search by containing text (like %text%)
    List<Product> findByNameContaining(String keyword);

    // 2. Filter with starting text
    List<Product> findByNameStartingWith(String prefix);

    // 3. Price > value
    List<Product> findByPriceGreaterThan(double price);

    // 4. Price < value
    List<Product> findByPriceLessThan(double price);

    // 5. Between two created dates
    List<Product> findByCreatedDateBetween(LocalDate start, LocalDate end);

    // 6. Top 3 expensive
    List<Product> findTop3ByOrderByPriceDesc();

    // 7. All sorted by name ascending
    List<Product> findAllByOrderByNameAsc();
}
