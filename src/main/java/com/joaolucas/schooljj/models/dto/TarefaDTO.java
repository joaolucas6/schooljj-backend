package com.joaolucas.schooljj.models.dto;

import com.joaolucas.schooljj.models.entities.Tarefa;

import java.time.LocalDateTime;

public class TarefaDTO {

    private Long id;
    private Long professorId;
    private Long disciplinaId;
    private Long turmaId;
    private String titulo;
    private String proposta;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public TarefaDTO(){

    }

    public TarefaDTO(Tarefa tarefa){
        setId(tarefa.getId());
        setProfessorId(tarefa.getProfessor().getId());
        setDisciplinaId(tarefa.getDisciplina().getId());
        setTurmaId(tarefa.getTurma().getId());
        setTitulo(tarefa.getTitulo());
        setProposta(tarefa.getProposta());
        setInicio(tarefa.getInicio());
        setFim(tarefa.getFim());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Long getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Long disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
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
}