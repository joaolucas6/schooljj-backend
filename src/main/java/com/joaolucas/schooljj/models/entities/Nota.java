package com.joaolucas.schooljj.models.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_nota")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nota")
    private Double nota;

    @OneToOne(mappedBy = "nota")
    private Resposta resposta;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Column(name = "observacoes", length = 3000)
    private String observacoes;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    public Nota(){

    }

    public Nota(Long id, Resposta resposta, Double nota, Tarefa tarefa, Professor professor, String observacoes, LocalDateTime dataCriacao) {
        this.id = id;
        this.resposta = resposta;
        this.nota = nota;
        this.professor = professor;
        this.observacoes = observacoes;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Nota nota = (Nota) object;
        return Objects.equals(id, nota.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", nota=" + nota +
                ", resposta=" + resposta +
                ", professor=" + professor +
                ", observacoes='" + observacoes + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
