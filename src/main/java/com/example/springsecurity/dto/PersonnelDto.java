package com.example.springsecurity.dto;

import com.example.springsecurity.models.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonnelDto {
    private Long id;
    private String name;
    private String personnelType;
    private Department department;
}
