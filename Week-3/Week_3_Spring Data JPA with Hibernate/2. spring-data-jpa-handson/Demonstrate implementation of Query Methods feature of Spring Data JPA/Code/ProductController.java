package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/search")
    public List<Product> searchByName(@RequestParam String keyword) {
        return repo.findByNameContaining(keyword);
    }

    @GetMapping("/startswith")
    public List<Product> startsWith(@RequestParam String prefix) {
        return repo.findByNameStartingWith(prefix);
    }

    @GetMapping("/price-above")
    public List<Product> priceAbove(@RequestParam double min) {
        return repo.findByPriceGreaterThan(min);
    }

    @GetMapping("/price-below")
    public List<Product> priceBelow(@RequestParam double max) {
        return repo.findByPriceLessThan(max);
    }

    @GetMapping("/between-dates")
    public List<Product> betweenDates(@RequestParam String start, @RequestParam String end) {
        return repo.findByCreatedDateBetween(LocalDate.parse(start), LocalDate.parse(end));
    }

    @GetMapping("/top3")
    public List<Product> top3() {
        return repo.findTop3ByOrderByPriceDesc();
    }

    @GetMapping("/sorted")
    public List<Product> sortedByName() {
        return repo.findAllByOrderByNameAsc();
    }
}
