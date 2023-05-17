package com.example.springsecurity.controllers;


import com.example.springsecurity.models.Personnel;
import com.example.springsecurity.services.DepartmentService;
import com.example.springsecurity.services.DepartmentServiceImpl;
import com.example.springsecurity.services.PersonnelService;
import com.example.springsecurity.services.PersonnelServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("personnel")
public class PersonnelController {
    public final PersonnelService personnelService;
    public final DepartmentService departmentService;
    public final DepartmentServiceImpl departmentServiceImpl;
    public final PersonnelServiceImpl personnelServiceImpl;

    public PersonnelController(PersonnelService personnelService, DepartmentService departmentService, DepartmentServiceImpl departmentServiceImpl, PersonnelServiceImpl personnelServiceImpl) {
        this.personnelService = personnelService;
        this.departmentService = departmentService;
        this.departmentServiceImpl = departmentServiceImpl;
        this.personnelServiceImpl = personnelServiceImpl;
    }


    //@Secured("ROLE_DEPARTMENTMANAGEMENT")
    @GetMapping()
    public Collection<Personnel> getAllPersonnel(){

        return personnelService.getAllPersonnel();
    }
    //@Secured("ROLE_DEPARTMENTMANAGEMENT")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePersonnel(@PathVariable(value = "id")Long id){
        personnelService.deletePersonnel(id);
        return ResponseEntity.noContent().build();
    }

    //@Secured("ROLE_DEPARTMENTMANAGEMENT")
    @PostMapping()
    public ResponseEntity<Personnel> addPersonnel(@RequestBody Personnel personnel){
        personnelService.addPersonnel(personnel);
        return ResponseEntity.ok(personnel);
    }

    //@Secured("ROLE_DEPARTMENTMANAGEMENT")
    @GetMapping("/{personnelId}")
    public Personnel getPersonnelById(@PathVariable Long personnelId){
        return personnelService.getPersonnelById(personnelId);
    }

    //@Secured("ROLE_DEPARTMENTMANAGEMENT")
    @PostMapping("/department/{id}")
    @ResponseBody
    public ResponseEntity<Personnel> addPersonnelByDepartmentId(@PathVariable Long id, @RequestBody Personnel personnel){
        return new ResponseEntity<>(departmentService.addPersonnelByDepartmentId(id,personnel), HttpStatus.CREATED);
    }

    //@Secured("ROLE_DEPARTMENTMANAGEMENT")
    @PutMapping()
    public Personnel updatePersonnel(@RequestBody Personnel personnel){
        personnelService.saveOrUpdate(personnel);
        return personnel;
    }





}
