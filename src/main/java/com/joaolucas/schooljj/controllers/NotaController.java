package com.joaolucas.schooljj.controllers;

import com.joaolucas.schooljj.models.dto.NotaDTO;
import com.joaolucas.schooljj.services.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notas")
@RequiredArgsConstructor
public class NotaController {

    private final NotaService notaService;

    @GetMapping
    public ResponseEntity<List<NotaDTO>> retornarTodos(){
        return ResponseEntity.ok(notaService.retornarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaDTO> retornarPorId(@PathVariable Long id){
        return ResponseEntity.ok(notaService.retornarPorId(id));
    }

    @PostMapping
    public ResponseEntity<NotaDTO> criar(@RequestBody NotaDTO notaDTO){
        return ResponseEntity.ok(notaService.criar(notaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaDTO> atualizar(@PathVariable Long id, @RequestBody NotaDTO notaDTO){
        return ResponseEntity.ok(notaService.atualizar(id, notaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        notaService.deletar(id);
        return ResponseEntity.ok().build();
    }


}
