package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.models.dto.ProfessorDTO;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.repositories.ProfessorRepository;
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
class ProfessorServiceTest {

    @Mock
    private ProfessorRepository professorRepository;
    private ProfessorService emTeste;
    private Professor professor;

    @BeforeEach
    void setUp() {
        emTeste = new ProfessorService(professorRepository);
        professor = new Professor();
    }

    @Test
    void deveRetornarTodosOsProfessores() {
        when(professorRepository.findAll()).thenReturn(List.of(professor));

        var resultado = emTeste.retornarTodos();

        assertThat(resultado).isEqualTo(List.of(new ProfessorDTO(professor)));
    }

    @Test
    void deveRetornarProfessorPorId() {
        when(professorRepository.findById(1L)).thenReturn(Optional.of(professor));

        var resultado = emTeste.retornarPorId(1L);

        assertThat(resultado).isEqualTo(new ProfessorDTO(professor));
    }

    @Test
    void deveAtualizarProfessor() {
        when(professorRepository.findById(1L)).thenReturn(Optional.of(professor));
        when(professorRepository.save(professor)).thenReturn(professor);

        ProfessorDTO paraAtualizar = new ProfessorDTO(professor);
        paraAtualizar.setNome("girafales");

        var resultado = emTeste.atualizar(1L, paraAtualizar);

        assertThat(resultado.getNome()).isEqualTo("girafales");
    }

    @Test
    void deveDeletarProfessor() {
        when(professorRepository.findById(1L)).thenReturn(Optional.of(professor));

        emTeste.deletar(1L);

        verify(professorRepository, times(1)).delete(professor);
    }
}