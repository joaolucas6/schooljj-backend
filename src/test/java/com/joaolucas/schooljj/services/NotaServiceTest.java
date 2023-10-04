package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.models.dto.NotaDTO;
import com.joaolucas.schooljj.models.entities.Nota;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.models.entities.Resposta;
import com.joaolucas.schooljj.repositories.NotaRepository;
import com.joaolucas.schooljj.repositories.ProfessorRepository;
import com.joaolucas.schooljj.repositories.RespostaRepository;
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
class NotaServiceTest {

    @Mock
    private NotaRepository notaRepository;
    @Mock
    private RespostaRepository respostaRepository;
    @Mock
    private ProfessorRepository professorRepository;
    private NotaService emTeste;
    private Nota nota;
    private Professor professor;
    private Resposta resposta;

    @BeforeEach
    void setUp() {
        emTeste = new NotaService(notaRepository, respostaRepository, professorRepository);
        nota = new Nota();
    }

    @Test
    void deveRetornarTodasAsNotas() {
        when(notaRepository.findAll()).thenReturn(List.of(nota));

        var resultado = emTeste.retornarTodos();

        assertThat(resultado).isEqualTo(List.of(new NotaDTO(nota)));
    }

    @Test
    void deveRetornarNotaPorId() {
        when(notaRepository.findById(1L)).thenReturn(Optional.of(nota));

        var resultado = emTeste.retornarPorId(1L);

        assertThat(resultado).isEqualTo(new NotaDTO(nota));
    }

    @Test
    void deveCriarNota() {
        professor = new Professor();
        resposta = new Resposta();

        when(professorRepository.findById(1L)).thenReturn(Optional.of(professor));
        when(respostaRepository.findById(1L)).thenReturn(Optional.of(resposta));
        when(notaRepository.save(nota)).thenReturn(nota);

        NotaDTO notaDTO = new NotaDTO(nota);
        notaDTO.setProfessorId(1L);
        notaDTO.setRespostaId(1L);

        var resultado = emTeste.criar(notaDTO);

        assertThat(resultado).isNotNull();
        assertThat(professor.getNotas().contains(nota) && resposta.getNota() == nota).isTrue();
    }

    @Test
    void deveEditarNota() {
        when(notaRepository.findById(1L)).thenReturn(Optional.of(nota));
        when(notaRepository.save(nota)).thenReturn(nota);

        NotaDTO paraAtualizar = new NotaDTO(nota);
        nota.setObservacoes("bom ein");

        var resultado = emTeste.atualizar(1L, paraAtualizar);

        assertThat(resultado.getObservacoes()).isEqualTo("bom ein");
    }

    @Test
    void deveDeletarNota() {
        when(notaRepository.findById(1L)).thenReturn(Optional.of(nota));

        emTeste.deletar(1L);

        verify(notaRepository, times(1)).delete(nota);
    }
}