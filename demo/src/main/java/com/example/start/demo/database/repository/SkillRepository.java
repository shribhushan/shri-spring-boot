package com.example.start.demo.database.repository;

import com.example.start.demo.database.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {

  // custom query methods if needed
}

