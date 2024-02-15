package com.example.start.demo.controller;

import com.example.start.demo.database.entity.Skill;
import com.example.start.demo.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService skillService;

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable("id") Long skillId) {
        return skillService.getSkillById(skillId);
    }

    @PostMapping
    public Skill createSkill(@RequestBody Skill skill) {
        return skillService.createSkill(skill);
    }

    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable("id") Long skillId, @RequestBody Skill skillDetails) {
        return skillService.updateSkill(skillId, skillDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable("id") Long skillId) {
        skillService.deleteSkill(skillId);
        return ResponseEntity.ok().build();
    }
}
