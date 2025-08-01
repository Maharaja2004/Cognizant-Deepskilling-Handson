package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentName(String departmentName);

    List<Employee> findByName(String name);

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmailCustom(@Param("email") String email);

    @Query(name = "Employee.findAllByEmailDomain")
    List<Employee> findByEmailDomain(@Param("domain") String domain);
}
