package com.example.springsecurity.repos;


import com.example.springsecurity.models.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel,Long> {


}
