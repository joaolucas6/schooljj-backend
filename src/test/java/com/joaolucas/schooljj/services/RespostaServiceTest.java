package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.models.dto.RespostaDTO;
import com.joaolucas.schooljj.models.entities.Aluno;
import com.joaolucas.schooljj.models.entities.Resposta;
import com.joaolucas.schooljj.models.entities.Tarefa;
import com.joaolucas.schooljj.repositories.AlunoRepository;
import com.joaolucas.schooljj.repositories.RespostaRepository;
import com.joaolucas.schooljj.repositories.TarefaRepository;
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
class RespostaServiceTest {

    @Mock
    private RespostaRepository respostaRepository;
    @Mock
    private TarefaRepository tarefaRepository;
    @Mock
    private AlunoRepository alunoRepository;
    private RespostaService emTeste;
    private Resposta resposta;
    private Tarefa tarefa;
    private Aluno aluno;

    @BeforeEach
    void setUp() {
        emTeste = new RespostaService(respostaRepository, tarefaRepository, alunoRepository);
        resposta = new Resposta();
    }

    @Test
    void deveRetornarTodasAsRespostas() {
        when(respostaRepository.findAll()).thenReturn(List.of(resposta));

        var resultado = emTeste.retornarTodos();

        assertThat(resultado).isEqualTo(List.of(new RespostaDTO(resposta)));
    }

    @Test
    void deveRetornarRespostaPorId() {
        when(respostaRepository.findById(1L)).thenReturn(Optional.of(resposta));

        var resultado = emTeste.retornarPorId(1L);

        assertThat(resultado).isEqualTo(new RespostaDTO(resposta));
    }

    @Test
    void deveCriarResposta() {
        tarefa = new Tarefa();
        aluno = new Aluno();

        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));
        when(respostaRepository.save(resposta)).thenReturn(resposta);

        RespostaDTO respostaDTO = new RespostaDTO(resposta);
        respostaDTO.setTarefaId(1L);
        respostaDTO.setAlunoId(1L);

        var resultado = emTeste.criar(respostaDTO);

        assertThat(resultado).isNotNull();
    }

    @Test
    void deveAtualizarResposta() {
        when(respostaRepository.findById(1L)).thenReturn(Optional.of(resposta));
        when(respostaRepository.save(resposta)).thenReturn(resposta);

        RespostaDTO paraAtualizar = new RespostaDTO(resposta);
        resposta.setTexto("historietas assombradas para crianças mal criadas");

        var resultado = emTeste.atualizar(1L, paraAtualizar);

        assertThat(resultado.getTexto()).isEqualTo("historietas assombradas para crianças mal criadas");
    }

    @Test
    void deveDeletarResposta() {
        when(respostaRepository.findById(1L)).thenReturn(Optional.of(resposta));

        emTeste.deletar(1L);

        verify(respostaRepository, times(1)).delete(resposta);
    }

    @Test
    void deveAdicionarImagem() {
        when(respostaRepository.findById(1L)).thenReturn(Optional.of(resposta));

        emTeste.adicionarImagem(1L, "imagem");

        assertThat(resposta.getImagensUrl().contains("imagem")).isTrue();
    }

    @Test
    void deveRemoverImagem() {
        when(respostaRepository.findById(1L)).thenReturn(Optional.of(resposta));

        resposta.getImagensUrl().add("imagem");

        emTeste.removerImagem(1L, "imagem");

        assertThat(resposta.getImagensUrl().contains("imagem")).isFalse();
    }
}