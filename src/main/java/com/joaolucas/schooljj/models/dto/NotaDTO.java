package com.joaolucas.schooljj.models.dto;

import com.joaolucas.schooljj.models.entities.Nota;

import java.time.LocalDateTime;

public class NotaDTO {

    private Long id;
    private Double nota;
    private Long respostaId;
    private Long professorId;
    private String observacoes;
    private LocalDateTime dataCriacao;

    public NotaDTO(Nota nota){
        setId(nota.getId());
        setNota(nota.getNota());
        setRespostaId(nota.getResposta().getId());
        setProfessorId(nota.getProfessor().getId());
        setObservacoes(nota.getObservacoes());
        setDataCriacao(nota.getDataCriacao());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Long getRespostaId() {
        return respostaId;
    }

    public void setRespostaId(Long respostaId) {
        this.respostaId = respostaId;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
