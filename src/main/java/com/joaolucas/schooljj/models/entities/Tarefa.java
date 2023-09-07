package com.joaolucas.schooljj.models.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "proposta")
    private String proposta;

    @Column(name = "inicio")
    private LocalDateTime inicio;

    @Column(name = "fim")
    private LocalDateTime fim;

    public Tarefa(){

    }

    public Tarefa(Long id, Professor professor, Disciplina disciplina, Turma turma, String titulo, String proposta, LocalDateTime inicio, LocalDateTime fim) {
        this.id = id;
        this.professor = professor;
        this.disciplina = disciplina;
        this.turma = turma;
        this.titulo = titulo;
        this.proposta = proposta;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProposta() {
        return proposta;
    }

    public void setProposta(String proposta) {
        this.proposta = proposta;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Tarefa tarefa = (Tarefa) object;
        return Objects.equals(id, tarefa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", professor=" + professor +
                ", disciplina=" + disciplina +
                ", turma=" + turma +
                ", titulo='" + titulo + '\'' +
                ", proposta='" + proposta + '\'' +
                ", inicio=" + inicio +
                ", fim=" + fim +
                '}';
    }
}
