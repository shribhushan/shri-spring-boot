package com.example.start.demo.service;

import com.example.start.demo.database.entity.EmployeeSkill;
import com.example.start.demo.database.repository.EmployeeSkillRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeSkillService {
    private final EmployeeSkillRepository employeeSkillRepository;

    public List<EmployeeSkill> getAllEmployeeSkills() {
        return employeeSkillRepository.findAll();
    }

    public EmployeeSkill getEmployeeSkillById(Long employeeSkillId) {
        return employeeSkillRepository.findById(employeeSkillId)
                .orElseThrow(() -> new EntityNotFoundException("Employee Skill not found with id: " + employeeSkillId));
    }

    public EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill) {
        return employeeSkillRepository.save(employeeSkill);
    }

    public EmployeeSkill updateEmployeeSkill(Long employeeSkillId, EmployeeSkill employeeSkillDetails) {
        EmployeeSkill employeeSkill = employeeSkillRepository.findById(employeeSkillId)
                .orElseThrow(() -> new EntityNotFoundException("Employee Skill not found with id: " + employeeSkillId));
        employeeSkill.setEmployee(employeeSkillDetails.getEmployee());
        employeeSkill.setSkill(employeeSkillDetails.getSkill());
        employeeSkill.setProficiency(employeeSkillDetails.getProficiency());
        return employeeSkillRepository.save(employeeSkill);
    }

    public void deleteEmployeeSkill(Long employeeSkillId) {
        EmployeeSkill employeeSkill = employeeSkillRepository.findById(employeeSkillId)
                .orElseThrow(() -> new EntityNotFoundException("Employee Skill not found with id: " + employeeSkillId));
        employeeSkillRepository.delete(employeeSkill);
    }
}
