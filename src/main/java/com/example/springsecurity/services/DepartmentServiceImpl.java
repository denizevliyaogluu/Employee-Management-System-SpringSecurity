package com.example.springsecurity.services;

import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Personnel;
import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.PersonnelRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private PersonnelRepository personnelRepository;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, PersonnelRepository personnelRepository) {
        this.departmentRepository = departmentRepository;
        this.personnelRepository = personnelRepository;
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void updateDepartment(Department department, Long id) {
        departmentRepository.save(department);
    }

    @Override
    public void saveOrUpdate(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Personnel addPersonnelByDepartmentId(Long id, Personnel personnel) {
        personnel.setDepartment(departmentRepository.findById(id).orElse(null));
        return personnelRepository.save(personnel);
    }

    @Override
    public Department addDepartment(Department department) {
        departmentRepository.save(department);
        return department;
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }


}
