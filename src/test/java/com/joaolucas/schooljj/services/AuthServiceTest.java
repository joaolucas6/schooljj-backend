package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.models.entities.Aluno;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.models.enums.Role;
import com.joaolucas.schooljj.models.records.RegisterRequest;
import com.joaolucas.schooljj.repositories.AlunoRepository;
import com.joaolucas.schooljj.repositories.ProfessorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    private AuthService emTeste;
    @Mock
    private ProfessorRepository professorRepository;
    @Mock
    private AlunoRepository alunoRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private UserService userService;
    @Mock
    private JwtService jwtService;

    @BeforeEach
    void setUp() {
        emTeste = new AuthService(professorRepository, alunoRepository, passwordEncoder, authenticationManager, userService, jwtService);
    }

    @Test
    void deveRegistrarAluno() {
        Aluno aluno = new Aluno();

        when(alunoRepository.save(aluno)).thenReturn(aluno);

        RegisterRequest request = new RegisterRequest("jo", "jo", "jojo@gmail.com", "jojo", Role.ALUNO);

        emTeste.registrarAluno(request);

        verify(alunoRepository, times(1)).save(aluno);
    }

    @Test
    void deveRegistrarProfessor() {
        Professor professor = new Professor();

        when(professorRepository.save(professor)).thenReturn(professor);

        RegisterRequest request = new RegisterRequest("jo", "jo", "jojo@gmail.com", "jojo", Role.PROFESSOR);

        emTeste.registrarProfessor(request);

        verify(professorRepository, times(1)).save(professor);
    }

}