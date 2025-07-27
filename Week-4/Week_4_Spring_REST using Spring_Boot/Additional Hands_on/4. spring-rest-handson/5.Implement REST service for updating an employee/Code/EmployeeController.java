package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.service.EmployeeService;
import com.cognizant.spring_learn.service.exception.EmployeeNotFoundException;
import jakarta.validation.Valid;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PutMapping
    public ResponseEntity<String> updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("START - updateEmployee");
        employeeService.updateEmployee(employee);
        LOGGER.info("END - updateEmployee");
        return ResponseEntity.ok("Employee updated successfully");
    }
    
    @GetMapping
    public List<Employee> getAllEmployees(){
    	return employeeService.getAllEmployees();
    }

}
