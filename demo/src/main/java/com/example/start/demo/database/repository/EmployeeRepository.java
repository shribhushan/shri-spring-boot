package com.example.start.demo.database.repository;

import com.example.start.demo.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  // custom query methods if needed
}

