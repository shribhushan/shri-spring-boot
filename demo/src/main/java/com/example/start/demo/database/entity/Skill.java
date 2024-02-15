package com.example.start.demo.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "skills")
@Data
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    private String name;

    @OneToMany(mappedBy = "skill")
    private Set<EmployeeSkill> employeeSkills;

}

