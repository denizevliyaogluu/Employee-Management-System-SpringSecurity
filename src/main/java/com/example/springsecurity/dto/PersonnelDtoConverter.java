package com.example.springsecurity.dto;

import com.example.springsecurity.models.Personnel;
import org.springframework.stereotype.Component;

@Component
public class PersonnelDtoConverter {
    public PersonnelDto convert(Personnel personnel){
        return PersonnelDto.builder()
                .id(personnel.getId())
                .name(personnel.getName())
                .personnelType(personnel.getPersonnelType())
                .department(personnel.getDepartment())
                .build();
    }
}
