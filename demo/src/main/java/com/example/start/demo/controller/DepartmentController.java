package com.example.start.demo.controller;

import com.example.start.demo.database.entity.Department;
import com.example.start.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department departmentDetails) {
        return departmentService.updateDepartment(departmentId, departmentDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok().build();
    }
}