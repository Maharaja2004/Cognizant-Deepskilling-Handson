package com.example.hibernatequerydemo;

import com.example.hibernatequerydemo.entity.Employee;
import com.example.hibernatequerydemo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
 class HqlNativeQueryDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HqlNativeQueryDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(EmployeeRepository repo) {
        return args -> {
            repo.save(new Employee("Maha", "HR", 30000));
            repo.save(new Employee("Raja", "IT", 50000));
            repo.save(new Employee("Kasi", "Finance", 45000));
            System.out.println("\n📌 Employees in IT department (HQL):");
            repo.findByDepartment("IT").forEach(System.out::println);

            // ✅ Native: Salary > 40000
            System.out.println("\n📌 Employees with salary > 40000 (Native SQL):");
            repo.findBySalaryGreaterThan(40000).forEach(System.out::println);

            // ✅ HQL Aggregate: Average salary
            System.out.println("\n📌 Average salary of all employees:");
            System.out.println(repo.findAverageSalary());
        };
    }
}
