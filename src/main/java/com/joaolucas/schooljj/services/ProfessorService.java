package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.exceptions.BadRequestException;
import com.joaolucas.schooljj.exceptions.ResourceNotFoundException;
import com.joaolucas.schooljj.models.dto.ProfessorDTO;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.repositories.ProfessorRepository;
import com.joaolucas.schooljj.utils.DataValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<ProfessorDTO> findAll(){
        return professorRepository.findAll().stream().map(ProfessorDTO::new).toList();
    }

    public ProfessorDTO findById(Long id){
        return new ProfessorDTO(professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Professor não foi encontrado com ID: " + id)));
    }

    public ProfessorDTO update(Long id, ProfessorDTO professorDTO){
        if(!DataValidation.isUserDataValid(professorDTO)) throw new BadRequestException("Os dados do professor são inválidos.");
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Professor não foi encontrado com ID: " + id));

        if(professorDTO.getNome() != null) professor.setNome(professorDTO.getNome());
        if(professorDTO.getSobrenome() != null) professor.setSobrenome(professorDTO.getSobrenome());
        if(professorDTO.getEmail() != null) professor.setEmail(professorDTO.getEmail());
        if(professorDTO.getGenero() != null) professor.setGenero(professorDTO.getGenero());
        if(professorDTO.getCpf() != null) professor.setCpf(professorDTO.getCpf());
        if(professorDTO.getNumeroTelefone() != null) professor.setNumeroTelefone(professorDTO.getNumeroTelefone());
        if(professorDTO.getDataNascimento() != null) professor.setDataNascimento(professorDTO.getDataNascimento());

        return new ProfessorDTO(professorRepository.save(professor));
    }

    public void delete(Long id){
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Professor não foi encontrado com ID: " + id));
        professorRepository.delete(professor);
    }
}
