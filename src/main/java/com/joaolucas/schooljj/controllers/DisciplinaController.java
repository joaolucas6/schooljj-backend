package com.joaolucas.schooljj.controllers;

import com.joaolucas.schooljj.models.dto.DisciplinaDTO;
import com.joaolucas.schooljj.services.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/disciplinas")
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<DisciplinaDTO>> retornarTodos(){
        return ResponseEntity.ok(disciplinaService.retornarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> retornarPorId(@PathVariable Long id){
        return ResponseEntity.ok(disciplinaService.retornarPorId(id));
    }

    @PostMapping
    public ResponseEntity<DisciplinaDTO> criar(@RequestBody DisciplinaDTO disciplinaDTO){
        return ResponseEntity.ok(disciplinaService.criar(disciplinaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> atualizar(@PathVariable Long id, @RequestBody DisciplinaDTO disciplinaDTO){
        return ResponseEntity.ok(disciplinaService.atualizar(id, disciplinaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        disciplinaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
