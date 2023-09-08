package com.joaolucas.schooljj.controllers;

import com.joaolucas.schooljj.models.dto.RespostaDTO;
import com.joaolucas.schooljj.services.RespostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/respostas")
@RequiredArgsConstructor
public class RespostaController {

    private final RespostaService respostaService;

    @GetMapping
    public ResponseEntity<List<RespostaDTO>> retornarTodos(){
        return ResponseEntity.ok(respostaService.retornarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaDTO> retornarPorId(@PathVariable Long id){
        return ResponseEntity.ok(respostaService.retornarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RespostaDTO> criar(@RequestBody RespostaDTO respostaDTO){
        return ResponseEntity.ok(respostaService.criar(respostaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespostaDTO> atualizar(@PathVariable Long id, @RequestBody RespostaDTO respostaDTO){
        return ResponseEntity.ok(respostaService.atualizar(id, respostaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        respostaService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{respostaId}/imagens/{imgUrl}")
    public ResponseEntity<Void> adicionarImagem(@PathVariable Long respostaId, @PathVariable String imgUrl){
        respostaService.adicionarImagem(respostaId, imgUrl);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{respostaId}/imagens/{imgUrl}")
    public ResponseEntity<Void> removerImagem(@PathVariable Long respostaId, @PathVariable String imgUrl){
        respostaService.removerImagem(respostaId, imgUrl);
        return ResponseEntity.ok().build();
    }


}
