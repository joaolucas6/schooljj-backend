package com.joaolucas.schooljj.repositories;

import com.joaolucas.schooljj.models.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
