package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.service.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    static {
        
        EMPLOYEE_LIST.add(new Employee(1, "John", 5000.0, true, null, null, new ArrayList<>()));
    }

    public void updateEmployee(Employee updatedEmployee) throws EmployeeNotFoundException {
        boolean found = false;
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(updatedEmployee.getId())) {
                EMPLOYEE_LIST.set(i, updatedEmployee);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
        return EMPLOYEE_LIST.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }
    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        boolean removed = EMPLOYEE_LIST.removeIf(e -> e.getId() == id);
        if (!removed) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
    }

}
