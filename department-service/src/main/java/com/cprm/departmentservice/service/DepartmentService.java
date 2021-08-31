package com.cprm.departmentservice.service;

import com.cprm.departmentservice.entity.Department;
import com.cprm.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    public DepartmentRepository departmentRepository;

    public List<Department> getAllDepatment(){
        return departmentRepository.findAll();
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
