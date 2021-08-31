package com.cprm.departmentservice.controller;

import com.cprm.departmentservice.entity.Department;
import com.cprm.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    @GetMapping
    public String getMessage(){
        return "Department API working";
    }

    @GetMapping("/getAllDepartment")
    public List<Department> getAllDepartment(){
        log.info("Inside getAllDepartments of DepartmentController");
        return departmentService.getAllDepatment();
    }

    @PostMapping("/addDepartment")
    public Department addDepartment(@RequestBody Department department){
        log.info("Inside addDepartment of DepartmentController");
        return departmentService.addDepartment(department);
    }

    @GetMapping("/getDepartment/{departmentId}")
    public Department getDepartmentById(@PathVariable("departmentId") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }
}
