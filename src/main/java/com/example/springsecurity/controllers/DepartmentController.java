package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Department;
import com.example.springsecurity.services.DepartmentService;
import com.example.springsecurity.services.DepartmentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("department")
public class DepartmentController {
    public final DepartmentService departmentService;
    public final DepartmentServiceImpl departmentServiceImpl;

    public DepartmentController(DepartmentService departmentService, DepartmentServiceImpl departmentServiceImpl) {
        this.departmentService = departmentService;
        this.departmentServiceImpl = departmentServiceImpl;
    }

    //@Secured("{ROLE_DEPARTMENTMANAGEMENT,ROLE_PERSONNEL}")
    @GetMapping()
    public ResponseEntity<?> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }


    //@Secured("ROLE_DEPARTMENTMANAGEMENT")
    @PostMapping()
    public Department addDepartment(@RequestBody Department department) {

        return departmentService.addDepartment(department);
    }

    //@Secured("ROLE_DEPARTMENTMANAGEMENT")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable(value = "id")Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

    //@Secured("ROLE_DEPARTMENTMANAGEMENT")
    @GetMapping("/{departmentId}")
    public Department getDepartmentById(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    //@Secured("ROLE_DEPARTMENTMANAGEMENT")
    @PutMapping()
    public Department updateDepartment(@RequestBody Department department){
        departmentService.saveOrUpdate(department);
        return department;
    }



}
