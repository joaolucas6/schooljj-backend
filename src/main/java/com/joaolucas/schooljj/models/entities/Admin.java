package com.joaolucas.schooljj.models.entities;

import com.joaolucas.schooljj.models.enums.Genero;
import com.joaolucas.schooljj.models.enums.Role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends User{

    public Admin() {
    }

    public Admin(Long id, String nome, String sobrenome, String email, String senha, Genero genero, String cpf, LocalDate dataNascimento, String numeroTelefone, Role role) {
        super(id, nome, sobrenome, email, senha, genero, cpf, dataNascimento, numeroTelefone, role);
    }

}
