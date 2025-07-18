package com.cognizant.orm_learn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Skill;
import com.cognizant.orm_learn.repository.EmployeeRepository;
import com.cognizant.orm_learn.repository.DepartmentRepository;
import com.cognizant.orm_learn.repository.SkillRepository;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside Main");

        testEmployeeDepartmentSkillMapping(context);
    }

    public static void testEmployeeDepartmentSkillMapping(ApplicationContext context) {
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
        SkillRepository skillRepository = context.getBean(SkillRepository.class);

        LOGGER.info("Start testEmployeeDepartmentSkillMapping");

        Department dept = new Department();
        dept.setName("Engineering");
        departmentRepository.save(dept);

        Skill skill1 = new Skill();
        skill1.setName("Java");
        skillRepository.save(skill1);

        Skill skill2 = new Skill();
        skill2.setName("Spring Boot");
        skillRepository.save(skill2);

        Employee emp = new Employee();
        emp.setName("Alice");
        emp.setSalary(75000);
        emp.setPermanent(true);
        emp.setDateOfBirth(new Date());
        emp.setDepartment(dept);

        List<Skill> skillList = new ArrayList<>();
        skillList.add(skill1);
        skillList.add(skill2);
        emp.setSkillList(skillList);

        employeeRepository.save(emp);

        Optional<Employee> savedEmp = employeeRepository.findById(emp.getId());
        LOGGER.debug("Saved Employee: {}", savedEmp);

        LOGGER.info("End testEmployeeDepartmentSkillMapping");
    }
}
