package com.example.start.demo.database.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name = "employee_skills")
@Data
public class EmployeeSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private Integer proficiency;
}
