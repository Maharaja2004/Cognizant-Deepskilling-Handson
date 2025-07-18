package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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

   
    @GetMapping("/paged")
    public Page<Employee> getAllPagedAndSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort
    ) {
        Sort.Direction dir = sort[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sort[0]));
        return employeeRepository.findAll(pageable);
    }
}
