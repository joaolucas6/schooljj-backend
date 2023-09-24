package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.exceptions.BadRequestException;
import com.joaolucas.schooljj.exceptions.ResourceNotFoundException;
import com.joaolucas.schooljj.models.dto.AdminDTO;
import com.joaolucas.schooljj.models.entities.Admin;
import com.joaolucas.schooljj.repositories.AdminRepository;
import com.joaolucas.schooljj.utils.DataValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public List<AdminDTO> retornarTodos(){
        return adminRepository.findAll().stream().map(AdminDTO::new).toList();
    }

    public AdminDTO retornarPorId(Long id){
        return new AdminDTO(adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin não foi encontrado com ID: " + id)));
    }

    public AdminDTO atualizar(Long id, AdminDTO adminDTO){
        if(!DataValidation.isUserDataValid(adminDTO)) throw new BadRequestException("Os dados do admin são inválidos.");

        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin não foi encontrado com ID: " + id));

        if(adminDTO.getNome() != null) admin.setNome(adminDTO.getNome());
        if(adminDTO.getSobrenome() != null) admin.setSobrenome(adminDTO.getSobrenome());
        if(adminDTO.getEmail() != null) admin.setEmail(adminDTO.getEmail());
        if(adminDTO.getGenero() != null) admin.setGenero(adminDTO.getGenero());
        if(adminDTO.getCpf() != null) admin.setCpf(adminDTO.getCpf());
        if(adminDTO.getDataNascimento() != null) admin.setDataNascimento(adminDTO.getDataNascimento());
        if(adminDTO.getNumeroTelefone() != null) admin.setNumeroTelefone(adminDTO.getNumeroTelefone());

        return new AdminDTO(adminRepository.save(admin));
    }

    public void deletar(Long id){
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin não foi encontrado com ID: " + id));
        adminRepository.delete(admin);
    }


}
