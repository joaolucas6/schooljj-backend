package com.joaolucas.schooljj.repositories;

import com.joaolucas.schooljj.models.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}
