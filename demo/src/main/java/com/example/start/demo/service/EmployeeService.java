package com.example.start.demo.service;

import com.example.start.demo.database.entity.Employee;
import com.example.start.demo.database.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long employeeId, Employee employeeDetails) {
        // Retrieve the employee from the database
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));

        // Update the employee details
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setHireDate(employeeDetails.getHireDate());
        employee.setJobTitle(employeeDetails.getJobTitle());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setManager(employeeDetails.getManager());

        // Save the updated employee to the database
        Employee updatedEmployee = employeeRepository.save(employee);
        log.info("Employee with id: {} has been updated", employeeId);
        return updatedEmployee;
    }

    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));
        employeeRepository.delete(employee);
    }
}
