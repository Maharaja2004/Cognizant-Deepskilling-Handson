package com.example.hibernatequerydemo.service;

import com.example.hibernatequerydemo.entity.Employee;
import com.example.hibernatequerydemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public double getAverageSalary(String department) {
        return employeeRepository.findAverageSalaryByDepartment(department);
    }

    public List<String> getAllEmployeeNames() {
        return employeeRepository.findAllEmployeeNames();
    }

    public List<Employee> getHighSalaryEmployees(double salary) {
        return employeeRepository.findEmployeesWithHighSalary(salary);
    }

    public void saveAll(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }
}
