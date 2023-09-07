package com.joaolucas.schooljj.repositories;

import com.joaolucas.schooljj.models.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
