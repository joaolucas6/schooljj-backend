package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.models.dto.TurmaDTO;
import com.joaolucas.schooljj.models.entities.Aluno;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.models.entities.Turma;
import com.joaolucas.schooljj.repositories.AlunoRepository;
import com.joaolucas.schooljj.repositories.ProfessorRepository;
import com.joaolucas.schooljj.repositories.TurmaRepository;
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
class TurmaServiceTest {

    @Mock
    private TurmaRepository turmaRepository;
    @Mock
    private AlunoRepository alunoRepository;
    @Mock
    private ProfessorRepository professorRepository;
    private TurmaService emTeste;
    private Turma turma;
    private Aluno aluno;
    private Professor professor;

    @BeforeEach
    void setUp() {
        emTeste = new TurmaService(turmaRepository, alunoRepository, professorRepository);
        turma = new Turma();
    }

    @Test
    void deveRetornarTodosAsTurmas() {
        when(turmaRepository.findAll()).thenReturn(List.of(turma));

        var resultado = emTeste.retornarTodos();

        assertThat(resultado).isEqualTo(List.of(new TurmaDTO(turma)));
    }

    @Test
    void deveRetornarTurmaPorId() {
        when(turmaRepository.findById(1L)).thenReturn(Optional.of(turma));

        var resultado = emTeste.retornarPorId(1L);

        assertThat(resultado).isEqualTo(new TurmaDTO(turma));
    }

    @Test
    void deveCriarTurma() {
        when(turmaRepository.save(turma)).thenReturn(turma);
        TurmaDTO turmaDTO = new TurmaDTO(turma);

        var resultado = emTeste.criar(turmaDTO);


        assertThat(resultado).isNotNull();
    }

    @Test
    void deveAtualizarTurma() {
        when(turmaRepository.findById(1L)).thenReturn(Optional.of(turma));
        when(turmaRepository.save(turma)).thenReturn(turma);

        TurmaDTO paraAtualizar = new TurmaDTO(turma);
        paraAtualizar.setNome("B");

        emTeste.atualizar(1L, paraAtualizar);

        assertThat(turma.getNome()).isEqualTo("B");
    }

    @Test
    void deveDeletarTurma() {
        when(turmaRepository.findById(1L)).thenReturn(Optional.of(turma));
        emTeste.deletar(1L);
        verify(turmaRepository, times(1)).delete(turma);
    }

    @Test
    void deveTransferirAluno() {
        aluno = new Aluno();

        when(turmaRepository.findById(1L)).thenReturn(Optional.of(turma));
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        emTeste.transferirAluno(1L, 1L);

        assertThat(aluno.getTurma() == turma && turma.getAlunos().contains(aluno)).isTrue();
    }

    @Test
    void deveAdicionarProfessor() {
        professor = new Professor();

        when(turmaRepository.findById(1L)).thenReturn(Optional.of(turma));
        when(professorRepository.findById(1L)).thenReturn(Optional.of(professor));

        emTeste.adicionarProfessor(1L, 1L);

        assertThat(professor.getTurmas().contains(turma) && turma.getProfessores().contains(professor)).isTrue();
    }

    @Test
    void deveRemoverProfessor() {
        professor = new Professor();

        when(turmaRepository.findById(1L)).thenReturn(Optional.of(turma));
        when(professorRepository.findById(1L)).thenReturn(Optional.of(professor));

        professor.getTurmas().add(turma);
        turma.getProfessores().add(professor);

        emTeste.removerProfessor(1L, 1L);

        assertThat(!professor.getTurmas().contains(turma) && !turma.getProfessores().contains(professor)).isTrue();
    }

}