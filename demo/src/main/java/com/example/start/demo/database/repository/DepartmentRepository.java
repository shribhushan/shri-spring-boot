package com.example.start.demo.database.repository;

import com.example.start.demo.database.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

  // custom query methods if needed
}

