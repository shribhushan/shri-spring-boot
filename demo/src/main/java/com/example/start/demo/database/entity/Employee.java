package com.example.start.demo.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private Date hireDate;

    private String jobTitle;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "employee")
    private Set<Salary> salaries;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeSkill> employeeSkills;

    // Getters and setters omitted for brevity
}


