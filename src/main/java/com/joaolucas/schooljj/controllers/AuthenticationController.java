package com.joaolucas.schooljj.controllers;

import com.joaolucas.schooljj.models.records.AuthenticationRequest;
import com.joaolucas.schooljj.models.records.RegisterRequest;
import com.joaolucas.schooljj.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/autenticacao")
public class AuthenticationController {
    
    private final AuthService authService;

    @PostMapping("/registrar/professores")
    public ResponseEntity<Void> registrarProfessor(@RequestBody RegisterRequest request){
        authService.registrarProfessor(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/autenticar/professores")
    public ResponseEntity<String> autenticarProfessor(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.autenticarProfessor(request));
    }

    @PostMapping("/registrar/alunos")
    public ResponseEntity<Void> registrarAluno(@RequestBody RegisterRequest request){
        authService.registrarAluno(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/autenticar/aluno")
    public ResponseEntity<String> autenticarAluno(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.autenticarAluno(request));
    }
}
