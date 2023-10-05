package com.joaolucas.schooljj.models.dto;

import com.joaolucas.schooljj.models.entities.Disciplina;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.models.entities.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DisciplinaDTO {

    private Long id;
    private String nome;
    private String descricao;
    private List<Long> professoresId = new ArrayList<>();
    private List<Long> tarefasId = new ArrayList<>();

    public DisciplinaDTO(Disciplina disciplina){
        setId(disciplina.getId());
        setNome(disciplina.getNome());
        setDescricao(disciplina.getDescricao());
        setProfessoresId(disciplina.getProfessores().stream().map(Professor::getId).toList());
        setTarefasId(disciplina.getTarefas().stream().map(Tarefa::getId).toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Long> getProfessoresId() {
        return professoresId;
    }

    public void setProfessoresId(List<Long> professoresId) {
        this.professoresId = professoresId;
    }

    public List<Long> getTarefasId() {
        return tarefasId;
    }

    public void setTarefasId(List<Long> tarefasId) {
        this.tarefasId = tarefasId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplinaDTO that = (DisciplinaDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && Objects.equals(professoresId, that.professoresId) && Objects.equals(tarefasId, that.tarefasId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, professoresId, tarefasId);
    }
}
