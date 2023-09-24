package com.joaolucas.schooljj.models.entities;

import com.joaolucas.schooljj.models.enums.Genero;
import com.joaolucas.schooljj.models.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Aluno")
public class Aluno extends User {

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @OneToMany(mappedBy = "aluno")
    private List<Resposta> respostas = new ArrayList<>();

    public Aluno(){

    }

    public Aluno(Long id, String nome, String sobrenome, String email, String senha, Genero genero, String cpf, LocalDate dataNascimento, String numeroTelefone, Role role, Turma turma) {
        super(id, nome, sobrenome, email, senha, genero, cpf, dataNascimento, numeroTelefone, role);
        this.turma = turma;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "turma=" + turma +
                ", respostas=" + respostas +
                '}';
    }
}
