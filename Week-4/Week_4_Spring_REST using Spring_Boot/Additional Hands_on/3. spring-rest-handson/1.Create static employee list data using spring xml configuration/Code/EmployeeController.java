package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.dao.EmployeeDao;
import com.cognizant.spring_learn.model.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeDao employeeDao = new EmployeeDao();

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeDao.getAllEmployees();

         System.out.println("Employee List");
        for (Employee emp : employeeList) {
            System.out.println(emp.getName());
        }

        return employeeList;
    }
}
