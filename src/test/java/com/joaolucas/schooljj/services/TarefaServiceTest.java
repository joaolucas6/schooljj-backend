package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.models.dto.TarefaDTO;
import com.joaolucas.schooljj.models.entities.Disciplina;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.models.entities.Tarefa;
import com.joaolucas.schooljj.models.entities.Turma;
import com.joaolucas.schooljj.repositories.DisciplinaRepository;
import com.joaolucas.schooljj.repositories.ProfessorRepository;
import com.joaolucas.schooljj.repositories.TarefaRepository;
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
class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;
    @Mock
    private DisciplinaRepository disciplinaRepository;
    @Mock
    private ProfessorRepository professorRepository;
    @Mock
    private TurmaRepository turmaRepository;
    private TarefaService emTeste;
    private Tarefa tarefa;
    private Disciplina disciplina;
    private Professor professor;
    private Turma turma;

    @BeforeEach
    void setUp() {
        emTeste = new TarefaService(tarefaRepository, disciplinaRepository, professorRepository, turmaRepository);

        tarefa = new Tarefa();
    }

    @Test
    void deveRetornarTodasAsTarefas() {
        when(tarefaRepository.findAll()).thenReturn(List.of(tarefa));

        var resultado = emTeste.retornarTodos();

        assertThat(resultado).isEqualTo(List.of(new TarefaDTO(tarefa)));
    }

    @Test
    void deveRetornarTarefaPorId() {
        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));

        var resultado = emTeste.retornarPorId(1L);

        assertThat(resultado).isEqualTo(new TarefaDTO(tarefa));
    }

    @Test
    void deveCriarTarefa() {
        disciplina = new Disciplina();
        professor = new Professor();
        turma = new Turma();

        when(disciplinaRepository.findById(1L)).thenReturn(Optional.of(disciplina));
        when(professorRepository.findById(1L)).thenReturn(Optional.of(professor));
        when(turmaRepository.findById(1L)).thenReturn(Optional.of(turma));
        when(tarefaRepository.save(tarefa)).thenReturn(tarefa);

        TarefaDTO tarefaDTO = new TarefaDTO();

        tarefaDTO.setProfessorId(1L);
        tarefaDTO.setDisciplinaId(1L);
        tarefaDTO.setTurmaId(1L);


        var resultado = emTeste.criar(tarefaDTO);

        assertThat(resultado).isNotNull();
    }

    @Test
    void deveAtualizarTarefa() {
        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));
        when(tarefaRepository.save(tarefa)).thenReturn(tarefa);


        TarefaDTO paraAtualizar = new TarefaDTO(tarefa);
        tarefa.setProposta("estudar");

        var resultado = emTeste.atualizar(1L, paraAtualizar);

        assertThat(resultado.getProposta()).isEqualTo("estudar");
    }

    @Test
    void deveDeletarTarefa() {
        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));
        emTeste.deletar(1L);
        verify(tarefaRepository, times(1)).delete(tarefa);
    }

}