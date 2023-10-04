package com.joaolucas.schooljj.models.dto;

import com.joaolucas.schooljj.models.entities.*;
import com.joaolucas.schooljj.models.enums.Genero;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ProfessorDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private Genero genero;
    private String cpf;
    private LocalDate dataNascimento;
    private String numeroTelefone;
    private List<Long> disciplinasId;
    private List<Long> turmasId;
    private List<Long> tarefasId;
    private List<Long> notasId;

    public ProfessorDTO(){

    }

    public ProfessorDTO(Professor professor){
        setId(professor.getId());
        setNome(professor.getNome());
        setSobrenome(professor.getSobrenome());
        setEmail(professor.getEmail());
        setGenero(professor.getGenero());
        setCpf(professor.getCpf());
        setDataNascimento(professor.getDataNascimento());
        setNumeroTelefone(professor.getNumeroTelefone());
        setDisciplinasId(professor.getDisciplinas().stream().map(Disciplina::getId).toList());
        setTurmasId(professor.getTurmas().stream().map(Turma::getId).toList());
        setTarefasId(professor.getTarefas().stream().map(Tarefa::getId).toList());
        setNotasId(professor.getNotas().stream().map(Nota::getId).toList());
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public List<Long> getDisciplinasId() {
        return disciplinasId;
    }

    public void setDisciplinasId(List<Long> disciplinasId) {
        this.disciplinasId = disciplinasId;
    }

    public List<Long> getTurmasId() {
        return turmasId;
    }

    public void setTurmasId(List<Long> turmasId) {
        this.turmasId = turmasId;
    }

    public List<Long> getTarefasId() {
        return tarefasId;
    }

    public void setTarefasId(List<Long> tarefasId) {
        this.tarefasId = tarefasId;
    }

    public List<Long> getNotasId() {
        return notasId;
    }

    public void setNotasId(List<Long> notasId) {
        this.notasId = notasId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorDTO that = (ProfessorDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(sobrenome, that.sobrenome) && Objects.equals(email, that.email) && genero == that.genero && Objects.equals(cpf, that.cpf) && Objects.equals(dataNascimento, that.dataNascimento) && Objects.equals(numeroTelefone, that.numeroTelefone) && Objects.equals(disciplinasId, that.disciplinasId) && Objects.equals(turmasId, that.turmasId) && Objects.equals(tarefasId, that.tarefasId) && Objects.equals(notasId, that.notasId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, email, genero, cpf, dataNascimento, numeroTelefone, disciplinasId, turmasId, tarefasId, notasId);
    }
}
