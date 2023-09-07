package com.joaolucas.schooljj.models.entities;


import com.joaolucas.schooljj.models.enums.Genero;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Professor")
public class Professor extends User {

    @ManyToMany(mappedBy = "professores")
    private List<Disciplina> disciplinas = new ArrayList<>();

    @ManyToMany(mappedBy = "professores")
    private List<Turma> turmas = new ArrayList<>();

    @OneToMany(mappedBy = "professor")
    private List<Tarefa> tarefas = new ArrayList<>();

    @OneToMany(mappedBy = "professor")
    private List<Nota> notas = new ArrayList<>();

    public Professor() {
    }

    public Professor(Long id, String nome, String sobrenome, String email, String senha, Genero genero, String cpf, LocalDate dataNascimento, String numeroTelefone) {
        super(id, nome, sobrenome, email, senha, genero, cpf, dataNascimento, numeroTelefone);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "disciplinas=" + disciplinas +
                ", turmas=" + turmas +
                ", tarefas=" + tarefas +
                ", notas=" + notas +
                '}';
    }
}
