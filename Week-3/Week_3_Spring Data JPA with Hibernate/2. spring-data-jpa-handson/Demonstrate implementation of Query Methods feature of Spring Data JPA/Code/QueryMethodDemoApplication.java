package com.example.demo;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class QueryMethodDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryMethodDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(ProductRepository repo) {
		return args -> {
			repo.save(new Product("Laptop", 75000, LocalDate.of(2024, 1, 10)));
			repo.save(new Product("Mobile", 25000, LocalDate.of(2024, 3, 5)));
			repo.save(new Product("Tablet", 15000, LocalDate.of(2024, 5, 20)));
			repo.save(new Product("Camera", 30000, LocalDate.of(2024, 6, 15)));
			repo.save(new Product("Monitor", 18000, LocalDate.of(2024, 7, 5)));
			repo.save(new Product("Keyboard", 1200, LocalDate.of(2024, 7, 7)));
		};
	}
}
