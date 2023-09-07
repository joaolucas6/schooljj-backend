package com.joaolucas.schooljj.repositories;

import com.joaolucas.schooljj.models.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
