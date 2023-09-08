package com.joaolucas.schooljj.controllers;

import com.joaolucas.schooljj.models.dto.ProfessorDTO;
import com.joaolucas.schooljj.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> retornarTodos(){
        return ResponseEntity.ok(professorService.retornarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> retornarPorId(@PathVariable Long id){
        return ResponseEntity.ok(professorService.retornarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDTO> atualizar(@PathVariable Long id, @RequestBody ProfessorDTO professorDTO){
        return ResponseEntity.ok(professorService.atualizar(id, professorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        professorService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
