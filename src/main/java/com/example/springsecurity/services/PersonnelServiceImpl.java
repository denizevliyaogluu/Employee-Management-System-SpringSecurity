package com.example.springsecurity.services;

import com.example.springsecurity.dto.PersonnelDto;
import com.example.springsecurity.dto.PersonnelDtoConverter;
import com.example.springsecurity.models.Department;
import com.example.springsecurity.models.Personnel;
import com.example.springsecurity.repos.DepartmentRepository;
import com.example.springsecurity.repos.PersonnelRepository;
import com.example.springsecurity.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
@Transactional
public class PersonnelServiceImpl implements PersonnelService {
    private PersonnelRepository personnelRepository;
    private UserRepository userRepository;
    private DepartmentRepository departmentRepository;
    private PersonnelDtoConverter personnelDtoConverter;

    public PersonnelServiceImpl(PersonnelRepository personnelRepository,UserRepository userRepository,DepartmentRepository departmentRepository){
        this.userRepository = userRepository;
        this.personnelRepository = personnelRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void deletePersonnel(Long id) {
        personnelRepository.deleteById(id);
    }

    @Override
    public void updatePersonnel(Personnel personnel, Long id) {
        personnelRepository.save(personnel);
    }


    @Override
    public void saveOrUpdate(Personnel personnel) {
        personnelRepository.save(personnel);
    }

    @Override
    public Personnel getPersonnelById(Long id) {
        return personnelRepository.findById(id).get();
    }

    @Override
    public void addPersonnel(Personnel personnel) {
        personnelRepository.save(personnel);
    }

    @Override
    public PersonnelDto createPersonnel(PersonnelDto personnelDto) {
        Personnel personnel = new Personnel();
        personnel.setId(personnel.getId());
        personnel.setName(personnel.getName());
        personnel.setPersonnelType(personnel.getPersonnelType());
        personnel.setDepartment(personnel.getDepartment());

        personnelRepository.save(personnel);
        return personnelDtoConverter.convert(personnel);
    }

    @Override
    public Collection<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }


}
