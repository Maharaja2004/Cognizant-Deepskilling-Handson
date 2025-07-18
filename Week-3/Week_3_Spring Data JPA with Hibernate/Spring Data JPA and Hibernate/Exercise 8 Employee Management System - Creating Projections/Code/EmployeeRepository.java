package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.projection.EmployeeNameEmailView;
import com.example.employeemanagementsystem.projection.EmployeeSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

   
    List<Employee> findByDepartmentName(String departmentName);
    List<Employee> findByName(String name);

    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Employee findByEmailCustom(String email);

    @Query(name = "Employee.findAllByEmailDomain")
    List<Employee> findByEmailDomain(String domain);

  
    List<EmployeeNameEmailView> findProjectedBy();

 
    @Query("SELECT new com.example.employeemanagementsystem.projection.EmployeeSummary(e.name, d.name) " +
           "FROM Employee e JOIN e.department d")
    List<EmployeeSummary> fetchEmployeeSummaries();
}
