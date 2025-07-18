package com.example.hibernatequerydemo.repository;

import com.example.hibernatequerydemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // HQL Query - find by department
    @Query("SELECT e FROM Employee e WHERE e.department = ?1")
    List<Employee> findByDepartment(String dept);

    // Native Query - find by salary greater than value
    @Query(value = "SELECT * FROM employees WHERE salary > ?1", nativeQuery = true)
    List<Employee> findBySalaryGreaterThan(double amount);

    // Aggregate - HQL: average salary
    @Query("SELECT AVG(e.salary) FROM Employee e")
    Double findAverageSalary();
}
