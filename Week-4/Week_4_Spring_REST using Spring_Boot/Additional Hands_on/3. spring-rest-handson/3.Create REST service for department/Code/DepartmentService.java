package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.dao.DepartmentDao;
import com.cognizant.spring_learn.model.Department;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentDao departmentDao = new DepartmentDao();

    @Transactional
    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}
