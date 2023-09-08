package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.exceptions.BadRequestException;
import com.joaolucas.schooljj.exceptions.ConflictException;
import com.joaolucas.schooljj.exceptions.ResourceNotFoundException;
import com.joaolucas.schooljj.models.dto.TurmaDTO;
import com.joaolucas.schooljj.models.entities.Aluno;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.models.entities.Turma;
import com.joaolucas.schooljj.repositories.AlunoRepository;
import com.joaolucas.schooljj.repositories.ProfessorRepository;
import com.joaolucas.schooljj.repositories.TurmaRepository;
import com.joaolucas.schooljj.utils.DataValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;

    public List<TurmaDTO> retornarTodos(){
        return turmaRepository.findAll().stream().map(TurmaDTO::new).toList();
    }

    public TurmaDTO retornarPorId(Long id){
        return new TurmaDTO(turmaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Turma não foi encontrada com ID: " + id)));
    }

    public TurmaDTO criar(TurmaDTO turmaDTO){
        if(!DataValidation.isTurmaDataValid(turmaDTO)) throw new BadRequestException("Dados da turma são inválidos.");

        Turma turma = new Turma();
        turma.setNome(turmaDTO.getNome());

        return new TurmaDTO(turmaRepository.save(turma));
    }

    public TurmaDTO atualizar(Long id, TurmaDTO turmaDTO){
        if(!DataValidation.isTurmaDataValid(turmaDTO)) throw new BadRequestException("Dados da turma são inválidos.");

        Turma turma = turmaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Turma não foi encontrada com ID: " + id));

        if(turmaDTO.getNome() != null) turma.setNome(turmaDTO.getNome());

        return new TurmaDTO(turmaRepository.save(turma));
    }

    public void deletar(Long id){
        Turma turma = turmaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Turma não foi encontrada com ID: " + id));
        turmaRepository.delete(turma);
    }

    public void transferirAluno(Long alunoId, Long turmaId){
        Turma turma = turmaRepository.findById(turmaId).orElseThrow(() -> new ResourceNotFoundException("Turma não foi encontrada com ID: " + turmaId));
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new ResourceNotFoundException("Aluno não foi encontrado com ID: "+ alunoId));


        Turma antigaTurma = aluno.getTurma();

        antigaTurma.getAlunos().remove(aluno);
        turma.getAlunos().add(aluno);
        aluno.setTurma(turma);

        turmaRepository.saveAll(List.of(antigaTurma, turma));
        alunoRepository.save(aluno);
    }

    public void adicionarProfessor(Long professorId, Long turmaId){
        Professor professor = professorRepository.findById(professorId).orElseThrow(() -> new ResourceNotFoundException("Professor não foi encontrado com ID: " + professorId));
        Turma turma = turmaRepository.findById(turmaId).orElseThrow(() -> new ResourceNotFoundException("Turma não foi encontrada com ID: " + turmaId));

        if(professor.getTurmas().contains(turma) || turma.getProfessores().contains(professor)) throw new ConflictException("Professor já está adicionado na turma.");

        professor.getTurmas().add(turma);
        turma.getProfessores().add(professor);

        professorRepository.save(professor);
        turmaRepository.save(turma);
    }

    public void removerProfessor(Long professorId, Long turmaId){
        Professor professor = professorRepository.findById(professorId).orElseThrow(() -> new ResourceNotFoundException("Professor não foi encontrado com ID: " + professorId));
        Turma turma = turmaRepository.findById(turmaId).orElseThrow(() -> new ResourceNotFoundException("Turma não foi encontrada com ID: " + turmaId));

        if(!professor.getTurmas().contains(turma) || !turma.getProfessores().contains(professor)) throw new ConflictException("Professor não está adicionado na turma.");

        professor.getTurmas().remove(turma);
        turma.getProfessores().remove(professor);

        professorRepository.save(professor);
        turmaRepository.save(turma);
    }

}
