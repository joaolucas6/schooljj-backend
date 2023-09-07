package com.joaolucas.schooljj.models.dto;

import com.joaolucas.schooljj.models.entities.*;
import com.joaolucas.schooljj.models.enums.Genero;

import java.time.LocalDate;
import java.util.List;

public class ProfessorDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
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
        setSenha(professor.getSenha());
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
}
