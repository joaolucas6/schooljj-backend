package com.joaolucas.schooljj.models.dto;

import com.joaolucas.schooljj.models.entities.Aluno;
import com.joaolucas.schooljj.models.entities.Resposta;
import com.joaolucas.schooljj.models.enums.Genero;

import java.time.LocalDate;
import java.util.List;

public class AlunoDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Genero genero;
    private String cpf;
    private LocalDate dataNascimento;
    private String numeroTelefone;
    private Long turmaId;
    private List<Long> respostasId;

    public AlunoDTO(){

    }

    public AlunoDTO(Aluno aluno){
        setId(aluno.getId());
        setNome(aluno.getNome());
        setSobrenome(aluno.getSobrenome());
        setEmail(aluno.getEmail());
        setSenha(aluno.getSenha());
        setGenero(aluno.getGenero());
        setCpf(aluno.getCpf());
        setDataNascimento(aluno.getDataNascimento());
        setNumeroTelefone(aluno.getNumeroTelefone());
        setTurmaId(aluno.getTurma().getId());
        setRespostasId(aluno.getRespostas().stream().map(Resposta::getId).toList());
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

    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }

    public List<Long> getRespostasId() {
        return respostasId;
    }

    public void setRespostasId(List<Long> respostasId) {
        this.respostasId = respostasId;
    }
}
