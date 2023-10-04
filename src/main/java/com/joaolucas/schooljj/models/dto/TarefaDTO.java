package com.joaolucas.schooljj.models.dto;

import com.joaolucas.schooljj.models.entities.Resposta;
import com.joaolucas.schooljj.models.entities.Tarefa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class TarefaDTO {

    private Long id;
    private Long professorId;
    private Long disciplinaId;
    private Long turmaId;
    private String titulo;
    private String proposta;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private LocalDateTime criadoEm;
    private List<Long> respostasId;

    public TarefaDTO(){

    }

    public TarefaDTO(Tarefa tarefa){
        setId(tarefa.getId());
        if(tarefa.getProfessor() != null) setProfessorId(tarefa.getProfessor().getId());
        if(tarefa.getDisciplina() != null) setDisciplinaId(tarefa.getDisciplina().getId());
        if(tarefa.getTurma() != null) setTurmaId(tarefa.getTurma().getId());
        setTitulo(tarefa.getTitulo());
        setProposta(tarefa.getProposta());
        setInicio(tarefa.getInicio());
        setFim(tarefa.getFim());
        setCriadoEm(tarefa.getCriadoEm());
        setRespostasId(tarefa.getRespostas().stream().map(Resposta::getId).toList());
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

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public List<Long> getRespostasId() {
        return respostasId;
    }

    public void setRespostasId(List<Long> respostasId) {
        this.respostasId = respostasId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TarefaDTO tarefaDTO = (TarefaDTO) o;
        return Objects.equals(id, tarefaDTO.id) && Objects.equals(professorId, tarefaDTO.professorId) && Objects.equals(disciplinaId, tarefaDTO.disciplinaId) && Objects.equals(turmaId, tarefaDTO.turmaId) && Objects.equals(titulo, tarefaDTO.titulo) && Objects.equals(proposta, tarefaDTO.proposta) && Objects.equals(inicio, tarefaDTO.inicio) && Objects.equals(fim, tarefaDTO.fim) && Objects.equals(criadoEm, tarefaDTO.criadoEm) && Objects.equals(respostasId, tarefaDTO.respostasId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, professorId, disciplinaId, turmaId, titulo, proposta, inicio, fim, criadoEm, respostasId);
    }
}
