package com.joaolucas.schooljj.controllers;

import com.joaolucas.schooljj.models.dto.TurmaDTO;
import com.joaolucas.schooljj.services.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/turmas")
@RequiredArgsConstructor
public class TurmaController {

    private final TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<TurmaDTO>> retornarTodos(){
        return ResponseEntity.ok(turmaService.retornarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaDTO> retornarPorId(@PathVariable Long id){
        return ResponseEntity.ok(turmaService.retornarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TurmaDTO> criar(@RequestBody TurmaDTO turmaDTO){
        return ResponseEntity.ok(turmaService.criar(turmaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaDTO> atualizar(@PathVariable Long id, @RequestBody TurmaDTO turmaDTO){
        return ResponseEntity.ok(turmaService.atualizar(id, turmaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        turmaService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{turmaId}/alunos/{alunoId}")
    public ResponseEntity<Void> transferirAluno(@PathVariable Long turmaId, @PathVariable Long alunoId){
        turmaService.transferirAluno(alunoId, turmaId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{turmaId}/professores")
    public ResponseEntity<Void> adicionarProfessor(@PathVariable Long turmaId, @PathVariable Long professorId){
        turmaService.adicionarProfessor(professorId, turmaId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{turmaId}/professores")
    public ResponseEntity<Void> removerProfessor(@PathVariable Long turmaId, @PathVariable Long professorId){
        turmaService.removerProfessor(professorId, turmaId);
        return ResponseEntity.ok().build();
    }

}
