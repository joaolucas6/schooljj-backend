package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.models.dto.DisciplinaDTO;
import com.joaolucas.schooljj.models.entities.Disciplina;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.repositories.DisciplinaRepository;
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
class DisciplinaServiceTest {

    @Mock
    private DisciplinaRepository disciplinaRepository;
    @Mock
    private ProfessorRepository professorRepository;
    private DisciplinaService emTeste;
    private Disciplina disciplina;
    private Professor professor;

    @BeforeEach
    void setUp() {
        emTeste = new DisciplinaService(disciplinaRepository, professorRepository);
        disciplina = new Disciplina();
    }

    @Test
    void deveRetornarTodasAsDisciplinas() {
        when(disciplinaRepository.findAll()).thenReturn(List.of(disciplina));

        var resultado = emTeste.retornarTodos();

        assertThat(resultado).isEqualTo(List.of(new DisciplinaDTO(disciplina)));
    }

    @Test
    void deveRetornarDisciplinaPorId() {
        when(disciplinaRepository.findById(1L)).thenReturn(Optional.of(disciplina));

        var resultado = emTeste.retornarPorId(1L);

        assertThat(resultado).isEqualTo(new DisciplinaDTO(disciplina));
    }

    @Test
    void deveCriarDisciplina() {
        when(disciplinaRepository.save(disciplina)).thenReturn(disciplina);

        var resultado = emTeste.criar(new DisciplinaDTO(disciplina));

        assertThat(resultado).isNotNull();
    }

    @Test
    void deveAtualizarDisciplina() {
        when(disciplinaRepository.findById(1L)).thenReturn(Optional.of(disciplina));
        when(disciplinaRepository.save(disciplina)).thenReturn(disciplina);

        DisciplinaDTO paraAtualizar = new DisciplinaDTO(disciplina);
        disciplina.setNome("fisica");

        var resultado = emTeste.atualizar(1L, paraAtualizar);

        assertThat(resultado).isNotNull();
        assertThat(disciplina.getNome()).isEqualTo("fisica");
    }

    @Test
    void deveDeletarDisciplina() {
        when(disciplinaRepository.findById(1L)).thenReturn(Optional.of(disciplina));

        emTeste.deletar(1L);

        verify(disciplinaRepository, times(1)).delete(disciplina);
    }

    @Test
    void deveAdicionarProfessorNaDisciplina() {
        professor = new Professor();

        when(disciplinaRepository.findById(1L)).thenReturn(Optional.of(disciplina));
        when(professorRepository.findById(1L)).thenReturn(Optional.of(professor));

        emTeste.adicionarProfessor(1L, 1L);

        assertThat(professor.getDisciplinas().contains(disciplina) && disciplina.getProfessores().contains(professor)).isTrue();
    }

    @Test
    void deveRemoverProfessorDaDisciplina() {
        professor = new Professor();
        when(disciplinaRepository.findById(1L)).thenReturn(Optional.of(disciplina));
        when(professorRepository.findById(1L)).thenReturn(Optional.of(professor));

        professor.getDisciplinas().add(disciplina);
        disciplina.getProfessores().add(professor);

        emTeste.removerProfessor(1L, 1L);

        assertThat(professor.getDisciplinas().contains(disciplina) || disciplina.getProfessores().contains(professor)).isFalse();
    }
}