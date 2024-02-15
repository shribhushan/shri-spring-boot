package com.example.start.demo.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String name;

    private String location;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    // Getters and setters omitted for brevity
}
