package com.example.springsecurity.models;

import com.example.springsecurity.repos.PersonnelRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String departmentName;

    public String address;
    public String phone;


   /* @JsonIgnore
    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToMany
    private List<Personnel> personnels = new ArrayList<>();*/

}
