package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.exceptions.BadRequestException;
import com.joaolucas.schooljj.exceptions.ResourceNotFoundException;
import com.joaolucas.schooljj.models.dto.DisciplinaDTO;
import com.joaolucas.schooljj.models.entities.Disciplina;
import com.joaolucas.schooljj.repositories.DisciplinaRepository;
import com.joaolucas.schooljj.utils.DataValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public List<DisciplinaDTO> retornarTodos(){
        return disciplinaRepository.findAll().stream().map(DisciplinaDTO::new).toList();
    }

    public DisciplinaDTO retornarPorId(Long id){
        return new DisciplinaDTO(disciplinaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Disciplina não foi encontrada com ID: " + id)));
    }

    public DisciplinaDTO criar(DisciplinaDTO disciplinaDTO){
        if(!DataValidation.isDisciplinaDataValid(disciplinaDTO)) throw new BadRequestException("Os dados da disciplina são inválidos.");
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(disciplinaDTO.getNome());
        disciplina.setDescricao(disciplinaDTO.getDescricao());
        return new DisciplinaDTO(disciplinaRepository.save(disciplina));
    }

    public DisciplinaDTO atualizar(Long id, DisciplinaDTO disciplinaDTO){
        if(!DataValidation.isDisciplinaDataValid(disciplinaDTO)) throw new BadRequestException("Os dados da disciplina são inválidos.");
        Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Disciplina não foi encontrada com ID: " + id));

        if(disciplinaDTO.getNome() != null) disciplina.setNome(disciplinaDTO.getNome());
        if(disciplinaDTO.getDescricao() != null) disciplina.setDescricao(disciplinaDTO.getDescricao());

        return new DisciplinaDTO(disciplinaRepository.save(disciplina));
    }

    public void deletar(Long id){
        Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Disciplina não foi encontrada com ID: " + id));
        disciplinaRepository.delete(disciplina);
    }


}
