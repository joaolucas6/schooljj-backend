package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.exceptions.BadRequestException;
import com.joaolucas.schooljj.exceptions.ResourceNotFoundException;
import com.joaolucas.schooljj.models.dto.AlunoDTO;
import com.joaolucas.schooljj.models.entities.Aluno;
import com.joaolucas.schooljj.repositories.AlunoRepository;
import com.joaolucas.schooljj.utils.DataValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public List<AlunoDTO> findAll(){
        return alunoRepository.findAll().stream().map(AlunoDTO::new).toList();
    }

    public AlunoDTO findById(Long id){
        return new AlunoDTO(alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aluno não foi encontrado com ID: " + id)));
    }

    public AlunoDTO update(Long id, AlunoDTO alunoDTO){
        if(!DataValidation.isUserDataValid(alunoDTO)) throw new BadRequestException("Os dados do aluno são inválidos.");
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aluno não foi encontrado com ID: " + id));

        if(alunoDTO.getNome() != null) aluno.setNome(alunoDTO.getNome());
        if(alunoDTO.getSobrenome() != null) aluno.setSobrenome(alunoDTO.getSobrenome());
        if(alunoDTO.getEmail() != null) aluno.setEmail(alunoDTO.getEmail());
        if(alunoDTO.getGenero() != null) aluno.setGenero(alunoDTO.getGenero());
        if(alunoDTO.getCpf() != null) aluno.setCpf(alunoDTO.getCpf());
        if(alunoDTO.getDataNascimento() != null) aluno.setDataNascimento(aluno.getDataNascimento());
        if(alunoDTO.getNumeroTelefone() != null) aluno.setNumeroTelefone(alunoDTO.getNumeroTelefone());

        return new AlunoDTO(alunoRepository.save(aluno));
    }

    public void delete(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aluno não foi encontrado com ID: " + id));
        alunoRepository.delete(aluno);
    }

}
