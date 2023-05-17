package com.example.springsecurity.services;

import com.example.springsecurity.dto.PersonnelDto;
import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Personnel;
import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.PersonnelRepository;
import com.example.springsecurity.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface PersonnelService {
    /*private final UserRepository userRepository;
    private final PersonnelRepository personnelRepository;
    private final DepartmentRepository departmentRepository;

    public PersonnelService(UserRepository userRepository, PersonnelRepository personnelRepository, DepartmentRepository departmentRepository) {
        this.userRepository = userRepository;
        this.personnelRepository = personnelRepository;
        this.departmentRepository = departmentRepository;


    }

    public void addPersonnel(Personnel personnel){
        personnelRepository.save(personnel);
    }


    public List<Personnel> getAllPersonnel(){

        return personnelRepository.findAll();
    }
    public void deletePersonnel(Long id) {
        personnelRepository.deleteById(id);
    }

    public Personnel getPersonnelById(Long id){
        return personnelRepository.findById(id).get();
    }

    public void updatePersonnel(Personnel personnel, Long id){
        personnelRepository.save(personnel);
    }
    public void saveOrUpdate(Personnel personnel){
        personnelRepository.save(personnel);
    }*/

    void deletePersonnel(Long id);
    void updatePersonnel(Personnel personnel, Long id);
    void saveOrUpdate(Personnel personnel);

    Personnel getPersonnelById(Long id);

    void addPersonnel(Personnel personnel);

    PersonnelDto createPersonnel(PersonnelDto personnelDto);

    Collection<Personnel> getAllPersonnel();




}
