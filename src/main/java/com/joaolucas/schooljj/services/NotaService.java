package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.exceptions.BadRequestException;
import com.joaolucas.schooljj.exceptions.ResourceNotFoundException;
import com.joaolucas.schooljj.models.dto.NotaDTO;
import com.joaolucas.schooljj.models.entities.Nota;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.models.entities.Resposta;
import com.joaolucas.schooljj.repositories.NotaRepository;
import com.joaolucas.schooljj.repositories.ProfessorRepository;
import com.joaolucas.schooljj.repositories.RespostaRepository;
import com.joaolucas.schooljj.utils.DataValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaService {

    private final NotaRepository notaRepository;
    private final RespostaRepository respostaRepository;
    private final ProfessorRepository professorRepository;

    public List<NotaDTO> findAll(){
        return notaRepository.findAll().stream().map(NotaDTO::new).toList();
    }

    public NotaDTO findById(Long id){
        return new NotaDTO(notaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nota não foi encontrada com ID: " + id)));
    }

    public NotaDTO create(NotaDTO notaDTO, Long respostaId, Long professorId){
        Resposta resposta = respostaRepository.findById(respostaId).orElseThrow(() -> new ResourceNotFoundException("Resposta não foi encontrada com ID: " + respostaId));
        Professor professor = professorRepository.findById(professorId).orElseThrow(() -> new ResourceNotFoundException("Professor não foi encontrado com ID: " + professorId));

        Nota nota = new Nota();

        nota.setNota(notaDTO.getNota());
        nota.setResposta(resposta);
        nota.setProfessor(professor);
        nota.setObservacoes(notaDTO.getObservacoes());
        nota.setDataCriacao(LocalDateTime.now());

        resposta.setNota(nota);
        professor.getNotas().add(nota);

        respostaRepository.save(resposta);
        professorRepository.save(professor);

        return new NotaDTO(notaRepository.save(nota));
    }

    public NotaDTO update(Long id, NotaDTO notaDTO){
        if(DataValidation.isNotaDataValid(notaDTO)) throw new BadRequestException("Os dados da nota são inválidos.");

        Nota nota = notaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nota não foi encontrada com ID: " + id));
        if(notaDTO.getNota() != null) nota.setNota(notaDTO.getNota());
        if(notaDTO.getObservacoes() != null) nota.setObservacoes(notaDTO.getObservacoes());

        return new NotaDTO(notaRepository.save(nota));
    }

    public void delete(Long id){
        Nota nota = notaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nota não foi encontrada com ID: " + id));
        notaRepository.delete(nota);
    }
}