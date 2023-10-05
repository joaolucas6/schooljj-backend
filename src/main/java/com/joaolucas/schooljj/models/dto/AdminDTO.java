package com.joaolucas.schooljj.models.dto;

import com.joaolucas.schooljj.models.entities.Admin;
import com.joaolucas.schooljj.models.enums.Genero;

import java.time.LocalDate;
import java.util.Objects;

public class AdminDTO {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private Genero genero;
    private String cpf;
    private LocalDate dataNascimento;
    private String numeroTelefone;

    public AdminDTO(){

    }

    public AdminDTO(Admin admin){
        setId(admin.getId());
        setNome(admin.getNome());
        setSobrenome(admin.getSobrenome());
        setEmail(admin.getEmail());
        setGenero(admin.getGenero());
        setCpf(admin.getCpf());
        setDataNascimento(admin.getDataNascimento());
        setNumeroTelefone(admin.getNumeroTelefone());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminDTO adminDTO = (AdminDTO) o;
        return Objects.equals(id, adminDTO.id) && Objects.equals(nome, adminDTO.nome) && Objects.equals(sobrenome, adminDTO.sobrenome) && Objects.equals(email, adminDTO.email) && genero == adminDTO.genero && Objects.equals(cpf, adminDTO.cpf) && Objects.equals(dataNascimento, adminDTO.dataNascimento) && Objects.equals(numeroTelefone, adminDTO.numeroTelefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, email, genero, cpf, dataNascimento, numeroTelefone);
    }
}
