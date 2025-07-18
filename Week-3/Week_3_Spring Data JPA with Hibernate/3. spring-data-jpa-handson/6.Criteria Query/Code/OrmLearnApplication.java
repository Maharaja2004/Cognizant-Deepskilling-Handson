package com.cognizant.orm_learn;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.*;
import com.cognizant.orm_learn.service.*;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;
    private static AttemptService attemptService;
    private static ProductService productService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside Main");

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        attemptService = context.getBean(AttemptService.class);
        productService = context.getBean(ProductService.class);

        testGetAttemptDetail(1, 1);
        testGetAverageSalary(1);
        testGetAllEmployeesNative();
        testCriteriaQuery();
    }

    private static void testGetAttemptDetail(int userId, int attemptId) {
        LOGGER.info("Start: testGetAttemptDetail");

        Attempt attempt = attemptService.getAttempt(userId, attemptId);
        if (attempt == null) {
            LOGGER.warn("No attempt found for userId={} and attemptId={}", userId, attemptId);
            return;
        }

        LOGGER.debug("Username: {}", attempt.getUser().getName());
        LOGGER.debug("Attempt Date: {}", attempt.getDate());

        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
            Question question = aq.getQuestion();
            System.out.println(question.getText());

            List<AttemptOption> attemptOptions = aq.getAttemptOptions();
            for (AttemptOption ao : attemptOptions) {
                QuizOption option = ao.getOption();
                System.out.printf("%d) %-10s  %.1f   %b\n",
                        option.getId(),
                        option.getText(),
                        option.getScore(),
                        ao.isSelected());
            }
            System.out.println();
        }

        LOGGER.info("End: testGetAttemptDetail");
    }

    private static void testGetAverageSalary(int departmentId) {
        LOGGER.info("Start: testGetAverageSalary");
        double avgSalary = employeeService.getAverageSalary(departmentId);
        System.out.println("Average Salary of Department " + departmentId + ": " + avgSalary);
        LOGGER.info("End: testGetAverageSalary");
    }

    private static void testGetAllEmployeesNative() {
        LOGGER.info("Start: testGetAllEmployeesNative");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        employees.forEach(System.out::println);
        LOGGER.info("End: testGetAllEmployeesNative");
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

    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees: {}", employees);
        employees.forEach(e -> LOGGER.debug("Skills: {}", e.getSkillList()));
        LOGGER.info("End");
    }

    private static void testCriteriaQuery() {
        LOGGER.info("Start: testCriteriaQuery");

        List<Product> filteredProducts = productService.getFilteredProducts(
            8,          
            "Intel i5", 
            512,        
            "Windows",  
            4.0         
        );

        filteredProducts.forEach(System.out::println);
        LOGGER.info("End: testCriteriaQuery");
    }
}
