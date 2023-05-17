package com.example.springsecurity.services;

import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Personnel;
import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.PersonnelRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface DepartmentService {
    /*private final DepartmentRepository departmentRepository;
    private final PersonnelRepository personnelRepository;

    public DepartmentService(DepartmentRepository departmentRepository, PersonnelRepository personnelRepository) {
        this.departmentRepository = departmentRepository;
        this.personnelRepository = personnelRepository;
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department addDepartment(Department department) {
        departmentRepository.save(department);
        return department;
    }

    public Personnel addPersonnelByDepartmentId(Long id, Personnel personnel){
        personnel.setDepartment(departmentRepository.findById(id).orElse(null));
        return personnelRepository.save(personnel);
    }

    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).get();
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }

    public void updateDepartment(Department department, Long id){
        departmentRepository.save(department);
    }
    public void saveOrUpdate(Department department){
        departmentRepository.save(department);
    }*/

    void deleteDepartment(Long id);
    void updateDepartment(Department department, Long id);
    void saveOrUpdate(Department department);

    Department getDepartmentById(Long id);

    Personnel addPersonnelByDepartmentId(Long id, Personnel personnel);

    Department addDepartment(Department department);


    List<Department> getAllDepartment();

}
