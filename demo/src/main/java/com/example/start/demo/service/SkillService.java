package com.example.start.demo.service;

import com.example.start.demo.database.entity.Skill;
import com.example.start.demo.database.repository.SkillRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SkillService {
    private final SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkillById(Long skillId) {
        return skillRepository.findById(skillId)
                .orElseThrow(() -> new EntityNotFoundException("Skill not found with id: " + skillId));
    }

    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill updateSkill(Long skillId, Skill skillDetails) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new EntityNotFoundException("Skill not found with id: " + skillId));
        skill.setName(skillDetails.getName());
        return skillRepository.save(skill);
    }

    public void deleteSkill(Long skillId) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new EntityNotFoundException("Skill not found with id: " + skillId));
        skillRepository.delete(skill);
    }
}
