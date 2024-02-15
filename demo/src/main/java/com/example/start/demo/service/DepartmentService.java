package com.example.start.demo.service;

import com.example.start.demo.database.entity.Department;
import com.example.start.demo.database.repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + departmentId));
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long departmentId, Department departmentDetails) {
        // Find the department by id or throw an EntityNotFoundException
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + departmentId));

        // Update the name and location of the department
        department.setName(departmentDetails.getName());
        department.setLocation(departmentDetails.getLocation());

        // Save and return the updated department
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + departmentId));
        departmentRepository.delete(department);
    }
}
