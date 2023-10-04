package com.joaolucas.schooljj.models.dto;

import com.joaolucas.schooljj.models.entities.Aluno;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.models.entities.Tarefa;
import com.joaolucas.schooljj.models.entities.Turma;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TurmaDTO {

    private Long id;
    private String nome;
    private List<Long> professoresId = new ArrayList<>();
    private List<Long> alunosId = new ArrayList<>();
    private List<Long> tarefasId = new ArrayList<>();

    public TurmaDTO(Turma turma){
        setId(turma.getId());
        setNome(turma.getNome());
        setProfessoresId(turma.getProfessores().stream().map(Professor::getId).toList());
        setAlunosId(turma.getAlunos().stream().map(Aluno::getId).toList());
        setTarefasId(turma.getTarefas().stream().map(Tarefa::getId).toList());
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

    public List<Long> getProfessoresId() {
        return professoresId;
    }

    public void setProfessoresId(List<Long> professoresId) {
        this.professoresId = professoresId;
    }

    public List<Long> getAlunosId() {
        return alunosId;
    }

    public void setAlunosId(List<Long> alunosId) {
        this.alunosId = alunosId;
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
        TurmaDTO turmaDTO = (TurmaDTO) o;
        return Objects.equals(id, turmaDTO.id) && Objects.equals(nome, turmaDTO.nome) && Objects.equals(professoresId, turmaDTO.professoresId) && Objects.equals(alunosId, turmaDTO.alunosId) && Objects.equals(tarefasId, turmaDTO.tarefasId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, professoresId, alunosId, tarefasId);
    }
}
