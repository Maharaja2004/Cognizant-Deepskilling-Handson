package com.example.hibernatequerydemo.controller;

import com.example.hibernatequerydemo.entity.Employee;
import com.example.hibernatequerydemo.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepository repo;

    public EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/high-salary")
    public List<Employee> getHighSalaryEmployees(@RequestParam double minSalary) {
        return repo.findEmployeesWithSalaryGreaterThan(minSalary);
    }

    @GetMapping("/names-by-department")
    public List<String> getNamesByDepartment(@RequestParam String dept) {
        return repo.findNamesByDepartment(dept);
    }

    @GetMapping("/average-salary")
    public double getAverageSalary() {
        return repo.findAverageSalary();
    }

    @GetMapping("/native-by-department")
    public List<Employee> getByDepartmentNative(@RequestParam String dept) {
        return repo.findByDepartmentNative(dept);
    }
}
