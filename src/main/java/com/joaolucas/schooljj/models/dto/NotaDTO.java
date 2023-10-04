package com.joaolucas.schooljj.models.dto;

import com.joaolucas.schooljj.models.entities.Nota;

import java.time.LocalDateTime;
import java.util.Objects;

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
        if(nota.getResposta() != null) setRespostaId(nota.getResposta().getId());
        if(nota.getProfessor() != null) setProfessorId(nota.getProfessor().getId());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaDTO notaDTO = (NotaDTO) o;
        return Objects.equals(id, notaDTO.id) && Objects.equals(nota, notaDTO.nota) && Objects.equals(respostaId, notaDTO.respostaId) && Objects.equals(professorId, notaDTO.professorId) && Objects.equals(observacoes, notaDTO.observacoes) && Objects.equals(dataCriacao, notaDTO.dataCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nota, respostaId, professorId, observacoes, dataCriacao);
    }
}
