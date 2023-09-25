package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.models.entities.Aluno;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.models.enums.Role;
import com.joaolucas.schooljj.models.records.AuthenticationRequest;
import com.joaolucas.schooljj.models.records.RegisterRequest;
import com.joaolucas.schooljj.repositories.AlunoRepository;
import com.joaolucas.schooljj.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;

    public void registrarAluno(RegisterRequest request){
        Aluno aluno = new Aluno();
        aluno.setNome(request.nome());
        aluno.setSobrenome(request.sobrenome());
        aluno.setEmail(request.email());
        aluno.setSenha(passwordEncoder.encode(request.senha()));
        aluno.setRole(Role.ALUNO);

        alunoRepository.save(aluno);
    }

    public String autenticarAluno(AuthenticationRequest request){
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.email(), request.senha());

        authenticationManager.authenticate(authToken);

        return jwtService.gerarToken(userService.loadUserByUsername(request.email()));
    }

    public void registrarProfessor(RegisterRequest request){

        Professor professor = new Professor();

        professor.setNome(request.nome());
        professor.setSobrenome(request.sobrenome());
        professor.setEmail(request.email());
        professor.setSenha(passwordEncoder.encode(request.senha()));
        professor.setRole(Role.PROFESSOR);

        professorRepository.save(professor);
    }

    public String autenticarProfessor(AuthenticationRequest request){
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
        authenticationManager.authenticate(authToken);

        return jwtService.gerarToken(userService.loadUserByUsername(request.email()));
    }

}
