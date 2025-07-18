package com.cognizant.orm_learn;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Skill;
import com.cognizant.orm_learn.service.EmployeeService;
import com.cognizant.orm_learn.service.DepartmentService;
import com.cognizant.orm_learn.service.SkillService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside Main");

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        testAddSkillToEmployee();
        // testGetEmployee();
        // testAddEmployee();
        // testUpdateEmployee();
        // testGetDepartment();
    }

    private static void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());
        LOGGER.debug("Skills: {}", employee.getSkillList());
        LOGGER.info("End");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start");
        Employee employee = new Employee();
        employee.setName("John");
        employee.setSalary(50000);
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date());
        Department department = departmentService.get(1);
        employee.setDepartment(department);
        employeeService.save(employee);
        LOGGER.debug("Added Employee: {}", employee);
        LOGGER.info("End");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        Department newDept = departmentService.get(2);
        employee.setDepartment(newDept);
        employeeService.save(employee);
        LOGGER.debug("Updated Employee: {}", employee);
        LOGGER.info("End");
    }

    private static void testGetDepartment() {
        LOGGER.info("Start");
        Department department = departmentService.get(1);
        LOGGER.debug("Department: {}", department);
        LOGGER.debug("Employees in Department: {}", department.getEmployeeList());
        LOGGER.info("End");
    }

    private static void testAddSkillToEmployee() {
        LOGGER.info("Start");

        Employee employee = employeeService.get(1); 
        Skill skill = skillService.get(2); 

        Set<Skill> skills = new HashSet<>(employee.getSkillList());
        skills.add(skill);

        employee.setSkillList(skills);  
        employeeService.save(employee);

        LOGGER.debug("Updated Employee with New Skill: {}", employee);
        LOGGER.info("End");
    }
}
