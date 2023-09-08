package com.joaolucas.schooljj.controllers;

import com.joaolucas.schooljj.models.dto.TarefaDTO;
import com.joaolucas.schooljj.services.TarefaService;
import jakarta.persistence.PostLoad;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> retornarTodos(){
        return ResponseEntity.ok(tarefaService.retornarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> retornarPorId(@PathVariable Long id){
        return ResponseEntity.ok(tarefaService.retornarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> criar(@RequestBody TarefaDTO tarefaDTO){
        return ResponseEntity.ok(tarefaService.criar(tarefaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizar(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO){
        return ResponseEntity.ok(tarefaService.atualizar(id, tarefaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        tarefaService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
