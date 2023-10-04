package com.joaolucas.schooljj.models.dto;

import com.joaolucas.schooljj.models.entities.Resposta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RespostaDTO {

    private Long id;
    private Long tarefaId;
    private Long notaId;
    private Long alunoId;
    private LocalDateTime dataCriacao;
    private String texto;
    private List<String> imagensUrl = new ArrayList<>();

    public RespostaDTO(Resposta resposta){
        setId(resposta.getId());
        if(resposta.getTarefa() != null) setTarefaId(resposta.getTarefa().getId());
        if(resposta.getNota() != null) setNotaId(resposta.getNota().getId());
        if(resposta.getAluno() != null) setAlunoId(resposta.getAluno().getId());
        setDataCriacao(resposta.getDataCriacao());
        setTexto(resposta.getTexto());
        setImagensUrl(resposta.getImagensUrl());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTarefaId() {
        return tarefaId;
    }

    public void setTarefaId(Long tarefaId) {
        this.tarefaId = tarefaId;
    }

    public Long getNotaId() {
        return notaId;
    }

    public void setNotaId(Long notaId) {
        this.notaId = notaId;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<String> getImagensUrl() {
        return imagensUrl;
    }

    public void setImagensUrl(List<String> imagensUrl) {
        this.imagensUrl = imagensUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespostaDTO that = (RespostaDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(tarefaId, that.tarefaId) && Objects.equals(notaId, that.notaId) && Objects.equals(alunoId, that.alunoId) && Objects.equals(dataCriacao, that.dataCriacao) && Objects.equals(texto, that.texto) && Objects.equals(imagensUrl, that.imagensUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tarefaId, notaId, alunoId, dataCriacao, texto, imagensUrl);
    }
}
