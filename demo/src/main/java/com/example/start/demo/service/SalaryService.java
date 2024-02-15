package com.example.start.demo.service;

import com.example.start.demo.database.entity.Salary;
import com.example.start.demo.database.repository.SalaryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SalaryService {
    private final SalaryRepository salaryRepository;

    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    public Salary getSalaryById(Long salaryId) {
        return salaryRepository.findById(salaryId)
                .orElseThrow(() -> new EntityNotFoundException("Salary not found with id: " + salaryId));
    }

    public Salary createSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    public Salary updateSalary(Long salaryId, Salary salaryDetails) {
        Salary salary = salaryRepository.findById(salaryId)
                .orElseThrow(() -> new EntityNotFoundException("Salary not found with id: " + salaryId));
        salary.setEmployee(salaryDetails.getEmployee());
        salary.setStartDate(salaryDetails.getStartDate());
        salary.setEndDate(salaryDetails.getEndDate());
        salary.setAnnualSalary(salaryDetails.getAnnualSalary());
        return salaryRepository.save(salary);
    }

    public void deleteSalary(Long salaryId) {
        Salary salary = salaryRepository.findById(salaryId)
                .orElseThrow(() -> new EntityNotFoundException("Salary not found with id: " + salaryId));
        salaryRepository.delete(salary);
    }
}
