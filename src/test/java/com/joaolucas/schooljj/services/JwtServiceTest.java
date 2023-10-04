package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.models.entities.Aluno;
import com.joaolucas.schooljj.models.enums.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class JwtServiceTest {

    private JwtService underTest;
    private Aluno aluno;
    private String token;
    private String SECRET_KEY = "CDF6958BC4B8A955D665798D14182";
    private final long expiration = 86400000;

    @BeforeEach
    void setUp() {
        underTest = new JwtService(SECRET_KEY, expiration);

        aluno = new Aluno();

        aluno.setNome("jo");
        aluno.setSobrenome("jo");
        aluno.setEmail("jojo@gmail.com");
        aluno.setSenha("jojo");
        aluno.setRole(Role.ALUNO);

        token = "invalid token";
    }

    @Test
    void deveGerarToken() {
        var result = underTest.gerarToken(aluno);
        assertThat(result).isInstanceOf(String.class);
    }

    @Test
    void deveSoltarExcecaoPorTokenInvalido() {
        Assertions.assertThrows(RuntimeException.class, () -> underTest.validarToken(token));
    }

}