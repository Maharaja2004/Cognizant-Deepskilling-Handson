package com.example.employeemanagementsystem;

import com.example.employeemanagementsystem.model.Department;
import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.DepartmentRepository;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EmployeeManagementSystemApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Department hr = new Department();
        hr.setName("HR");
        departmentRepository.save(hr);

        employeeRepository.save(new Employee(null, "Alice", "alice@domain.com", hr));
        employeeRepository.save(new Employee(null, "Bob", "bob@domain.com", hr));
        employeeRepository.save(new Employee(null, "John", "john@another.com", hr));

        List<Employee> hrEmployees = employeeRepository.findByDepartmentName("HR");
        System.out.println("Employees in HR: " + hrEmployees.size());

        List<Employee> johns = employeeRepository.findByName("John");
        System.out.println("Employees named John: " + johns.size());

        Employee bob = employeeRepository.findByEmailCustom("bob@domain.com");
        System.out.println("Custom query - Bob's Name: " + bob.getName());

        List<Employee> domainEmails = employeeRepository.findByEmailDomain("domain.com");
        System.out.println("Employees with 'domain.com': " + domainEmails.size());
    }
}
