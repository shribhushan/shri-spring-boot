package com.example.start.demo.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "salaries")
@Data
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaryId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date startDate;

    private Date endDate;

    private BigDecimal annualSalary;

    // Getters and setters omitted for brevity
}

