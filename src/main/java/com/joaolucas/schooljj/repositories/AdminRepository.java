package com.joaolucas.schooljj.repositories;

import com.joaolucas.schooljj.models.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
