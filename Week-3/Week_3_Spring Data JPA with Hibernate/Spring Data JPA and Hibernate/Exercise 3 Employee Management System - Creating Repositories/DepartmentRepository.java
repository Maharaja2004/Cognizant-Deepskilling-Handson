package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    Department findByName(String name);
}
