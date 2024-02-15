package com.example.start.demo.controller;

import com.example.start.demo.database.entity.EmployeeSkill;
import com.example.start.demo.service.EmployeeSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeeskills")
@RequiredArgsConstructor
public class EmployeeSkillController {

    private final EmployeeSkillService employeeSkillService;

    @GetMapping
    public List<EmployeeSkill> getAllEmployeeSkills() {
        return employeeSkillService.getAllEmployeeSkills();
    }

    @GetMapping("/{id}")
    public EmployeeSkill getEmployeeSkillById(@PathVariable("id") Long employeeSkillId) {
        return employeeSkillService.getEmployeeSkillById(employeeSkillId);
    }

    @PostMapping
    public EmployeeSkill createEmployeeSkill(@RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.createEmployeeSkill(employeeSkill);
    }

    @PutMapping("/{id}")
    public EmployeeSkill updateEmployeeSkill(@PathVariable("id") Long employeeSkillId, @RequestBody EmployeeSkill employeeSkillDetails) {
        return employeeSkillService.updateEmployeeSkill(employeeSkillId, employeeSkillDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeSkill(@PathVariable("id") Long employeeSkillId) {
        employeeSkillService.deleteEmployeeSkill(employeeSkillId);
        return ResponseEntity.ok().build();
    }
}
