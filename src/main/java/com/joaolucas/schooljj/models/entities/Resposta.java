package com.joaolucas.schooljj.models.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_resposta")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private Tarefa tarefa;

    @OneToOne
    @JoinColumn(name = "nota_id")
    private Nota nota;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "texto", length = 3000)
    private String texto;

    @ElementCollection
    @CollectionTable(name = "imagens_resposta", joinColumns = @JoinColumn(name = "resposta_id"))
    @Column(name = "imagem_url")
    private List<String> imagensUrl = new ArrayList<>();

    public Resposta(){

    }

    public Resposta(Long id, Tarefa tarefa, Nota nota, Aluno aluno, LocalDateTime dataCriacao, String texto) {
        this.id = id;
        this.tarefa = tarefa;
        this.nota = nota;
        this.aluno = aluno;
        this.dataCriacao = dataCriacao;
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Resposta resposta = (Resposta) object;
        return Objects.equals(id, resposta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Resposta{" +
                "id=" + id +
                ", tarefa=" + tarefa +
                ", nota=" + nota +
                ", aluno=" + aluno +
                ", dataCriacao=" + dataCriacao +
                ", texto='" + texto + '\'' +
                ", imagensUrl=" + imagensUrl +
                '}';
    }
}
