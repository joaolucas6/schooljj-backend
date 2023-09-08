package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.exceptions.BadRequestException;
import com.joaolucas.schooljj.exceptions.ConflictException;
import com.joaolucas.schooljj.exceptions.ResourceNotFoundException;
import com.joaolucas.schooljj.models.dto.DisciplinaDTO;
import com.joaolucas.schooljj.models.entities.Disciplina;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.repositories.DisciplinaRepository;
import com.joaolucas.schooljj.repositories.ProfessorRepository;
import com.joaolucas.schooljj.utils.DataValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;
    private final ProfessorRepository professorRepository;

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

    public void adicionarProfessor(Long disciplinaId, Long professorId){
        Disciplina disciplina = disciplinaRepository.findById(disciplinaId).orElseThrow(() -> new ResourceNotFoundException("Disciplina não foi encontrada com ID: " + disciplinaId));
        Professor professor = professorRepository.findById(professorId).orElseThrow(() -> new ResourceNotFoundException("Professor não foi encontrado com ID: " + professorId));

        if(professor.getDisciplinas().contains(disciplina) || disciplina.getProfessores().contains(professor)) throw new ConflictException("Professor já está adicionado nessa disciplina.");

        disciplina.getProfessores().add(professor);
        professor.getDisciplinas().add(disciplina);

        disciplinaRepository.save(disciplina);
        professorRepository.save(professor);
    }

    public void removerProfessor(Long disciplinaId, Long professorId){
        Disciplina disciplina = disciplinaRepository.findById(disciplinaId).orElseThrow(() -> new ResourceNotFoundException("Disciplina não foi encontrada com ID: " + disciplinaId));
        Professor professor = professorRepository.findById(professorId).orElseThrow(() -> new ResourceNotFoundException("Professor não foi encontrado com ID: " + professorId));

        if(!professor.getDisciplinas().contains(disciplina) || !disciplina.getProfessores().contains(professor)) throw new ConflictException("Professor não está adicionado nessa disciplina.");

        disciplina.getProfessores().remove(professor);
        professor.getDisciplinas().remove(disciplina);

        disciplinaRepository.save(disciplina);
        professorRepository.save(professor);
    }

}
