package com.joaolucas.schooljj.models.dto;

import com.joaolucas.schooljj.models.entities.Resposta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        setTarefaId(resposta.getTarefa().getId());
        setNotaId(resposta.getNota().getId());
        setAlunoId(resposta.getAluno().getId());
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
}
