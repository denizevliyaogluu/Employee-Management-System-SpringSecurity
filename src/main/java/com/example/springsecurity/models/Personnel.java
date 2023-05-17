package com.example.springsecurity.models;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Personnel extends User{
    public String personnelType;
    public String phone;
    public String address;


    @JsonIgnore
    @ManyToOne
    private Department department;


}
