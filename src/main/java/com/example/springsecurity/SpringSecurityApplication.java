package com.example.springsecurity;

import com.example.springsecurity.models.*;
import com.example.springsecurity.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@Slf4j
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder()
    {
       return  new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService,DepartmentService departmentService, PersonnelService personnelService
                         ) {
        return args ->
        {
            userService.saveRole(new UserRole(null, "ROLE_PERSONNEL"));
            userService.saveRole(new UserRole(null, "ROLE_DEPARTMENTMANAGEMENT"));



            userService.saveUser(new User(null, "personel", "personnel", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "department", "departmentmanagement", "12345", new ArrayList<>()));


            userService.addRoleToUser("personnel", "ROLE_PERSONNEL");
            userService.addRoleToUser("departmentmanagement", "ROLE_DEPARTMENTMANAGEMENT");


            Personnel pr = new Personnel();
            pr.setPersonnelType("Developer");
            pr.setName("Deniz Evliyaoglu");
            personnelService.addPersonnel(pr);


            Department dp = new Department();
            dp.setDepartmentName("Software");
            departmentService.addDepartment(dp);

        };
    }
}
