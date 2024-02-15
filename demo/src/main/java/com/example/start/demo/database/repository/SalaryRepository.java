package com.example.start.demo.database.repository;

import com.example.start.demo.database.entity.EmployeeSkill;
import com.example.start.demo.database.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {

  // custom query methods if needed
}

