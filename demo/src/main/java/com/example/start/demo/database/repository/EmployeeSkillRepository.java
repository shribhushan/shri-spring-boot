package com.example.start.demo.database.repository;

import com.example.start.demo.database.entity.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

  // custom query methods if needed
}

