package com.joaolucas.schooljj.controllers;

import com.joaolucas.schooljj.models.dto.AlunoDTO;
import com.joaolucas.schooljj.services.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> retornarTodos(){
        return ResponseEntity.ok(alunoService.retornarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> retornarPorId(@PathVariable Long id){
        return ResponseEntity.ok(alunoService.retornarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> atualizar(@RequestBody AlunoDTO alunoDTO, @PathVariable Long id){
        return ResponseEntity.ok(alunoService.atualizar(id, alunoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        alunoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
