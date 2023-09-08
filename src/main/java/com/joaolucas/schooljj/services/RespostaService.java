package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.exceptions.BadRequestException;
import com.joaolucas.schooljj.exceptions.ResourceNotFoundException;
import com.joaolucas.schooljj.models.dto.RespostaDTO;
import com.joaolucas.schooljj.models.entities.Aluno;
import com.joaolucas.schooljj.models.entities.Resposta;
import com.joaolucas.schooljj.models.entities.Tarefa;
import com.joaolucas.schooljj.repositories.AlunoRepository;
import com.joaolucas.schooljj.repositories.RespostaRepository;
import com.joaolucas.schooljj.repositories.TarefaRepository;
import com.joaolucas.schooljj.utils.DataValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RespostaService {

    private final RespostaRepository respostaRepository;
    private final TarefaRepository tarefaRepository;
    private final AlunoRepository alunoRepository;

    public List<RespostaDTO> retornarTodos(){
        return respostaRepository.findAll().stream().map(RespostaDTO::new).toList();
    }

    public RespostaDTO retornarPorId(Long id){
        return new RespostaDTO(respostaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resposta não foi encontrada com ID: " + id)));
    }

    public RespostaDTO criar(RespostaDTO respostaDTO){
        if(!DataValidation.isRespostaDataValid(respostaDTO)) throw new BadRequestException("Os dados da resposta são inválidos");

        Tarefa tarefa = tarefaRepository.findById(respostaDTO.getTarefaId()).orElseThrow(() -> new ResourceNotFoundException("Tarefa não foi encontrada com ID: " + respostaDTO.getTarefaId()));
        Aluno aluno = alunoRepository.findById(respostaDTO.getAlunoId()).orElseThrow(() -> new ResourceNotFoundException("Aluno não foi encontrado com ID: " + respostaDTO.getAlunoId()));

        Resposta resposta = new Resposta();

        resposta.setTarefa(tarefa);
        resposta.setNota(null);
        resposta.setAluno(aluno);
        resposta.setDataCriacao(LocalDateTime.now());
        resposta.setTexto(respostaDTO.getTexto());

        Resposta savedResposta = respostaRepository.save(resposta);

        aluno.getRespostas().add(savedResposta);
        tarefa.getRespostas().add(savedResposta);

        alunoRepository.save(aluno);
        tarefaRepository.save(tarefa);

        return new RespostaDTO(savedResposta);
    }

    public RespostaDTO atualizar(Long id, RespostaDTO respostaDTO){
        if(!DataValidation.isRespostaDataValid(respostaDTO)) throw new BadRequestException("Os dados da resposta são inválidos");
        Resposta resposta = respostaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resposta não foi encontrada com ID: " + id));

        if(respostaDTO.getTexto() != null) resposta.setTexto(respostaDTO.getTexto());

        return new RespostaDTO(respostaRepository.save(resposta));
    }

    public void deletar(Long id){
        Resposta resposta = respostaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resposta não foi encontrada com ID: " + id));
        respostaRepository.delete(resposta);
    }

    public void adicionarImagem(Long respostaId, String imageUrl){
        Resposta resposta = respostaRepository.findById(respostaId).orElseThrow(() -> new ResourceNotFoundException("Resposta não foi encontrada com ID: " + respostaId));
        resposta.getImagensUrl().add(imageUrl);
        respostaRepository.save(resposta);
    }

    public void removerImagem(Long respostaId, String imageUrl){
        Resposta resposta = respostaRepository.findById(respostaId).orElseThrow(() -> new ResourceNotFoundException("Resposta não foi encontrada com ID: " + respostaId));
        resposta.getImagensUrl().remove(imageUrl);
        respostaRepository.save(resposta);
    }

}
