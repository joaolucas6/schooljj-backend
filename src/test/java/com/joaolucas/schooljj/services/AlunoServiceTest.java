package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.models.dto.AlunoDTO;
import com.joaolucas.schooljj.models.entities.Aluno;
import com.joaolucas.schooljj.repositories.AlunoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlunoServiceTest {

    @Mock
    private AlunoRepository alunoRepository;
    private AlunoService emTeste;
    private Aluno aluno;

    @BeforeEach
    void setUp() {
        aluno = new Aluno();
        emTeste = new AlunoService(alunoRepository);
    }

    @Test
    void deveRetornarTodosOsAlunos() {
        when(alunoRepository.findAll()).thenReturn(List.of(aluno));

        var resultado = emTeste.retornarTodos();

        assertThat(resultado).isEqualTo(List.of(new AlunoDTO(aluno)));
    }

    @Test
    void deveRetornarAlunoPorId() {
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        var resultado = emTeste.retornarPorId(1L);

        assertThat(resultado).isEqualTo(new AlunoDTO(aluno));
    }

    @Test
    void deveAtualizarAluno() {
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));
        when(alunoRepository.save(aluno)).thenReturn(aluno);

        AlunoDTO paraAtualizar = new AlunoDTO(aluno);
        paraAtualizar.setNome("jojo");

        var resultado = emTeste.atualizar(1L, paraAtualizar);

        assertThat(resultado).isNotNull();
        assertThat(aluno.getNome()).isEqualTo("jojo");
    }

    @Test
    void deveDeletarAluno() {
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        emTeste.deletar(1L);

        verify(alunoRepository, times(1)).delete(aluno);
    }
}