package com.example.start.demo.controller;

import com.example.start.demo.database.entity.Salary;
import com.example.start.demo.service.SalaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/salaries")
public class SalaryController {

    private final SalaryService salaryService;

    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @GetMapping("/{id}")
    public Salary getSalaryById(@PathVariable("id") Long salaryId) {
        return salaryService.getSalaryById(salaryId);
    }

    @PostMapping
    public Salary createSalary(@RequestBody Salary salary) {
        return salaryService.createSalary(salary);
    }

    @PutMapping("/{id}")
    public Salary updateSalary(@PathVariable("id") Long salaryId, @RequestBody Salary salaryDetails) {
        return salaryService.updateSalary(salaryId, salaryDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSalary(@PathVariable("id") Long salaryId) {
        salaryService.deleteSalary(salaryId);
        return ResponseEntity.ok().build();
    }
}