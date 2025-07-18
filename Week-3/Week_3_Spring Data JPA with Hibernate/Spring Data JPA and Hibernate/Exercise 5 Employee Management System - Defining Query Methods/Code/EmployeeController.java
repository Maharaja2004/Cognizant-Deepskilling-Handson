package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/by-department")
    public List<Employee> getByDepartmentName(@RequestParam String name) {
        return employeeRepository.findByDepartmentName(name);
    }

    @GetMapping("/by-name")
    public List<Employee> getByName(@RequestParam String name) {
        return employeeRepository.findByName(name);
    }

    @GetMapping("/by-email")
    public Employee getByEmail(@RequestParam String email) {
        return employeeRepository.findByEmailCustom(email);
    }

    @GetMapping("/by-domain")
    public List<Employee> getByEmailDomain(@RequestParam String domain) {
        return employeeRepository.findByEmailDomain(domain);
    }
}
