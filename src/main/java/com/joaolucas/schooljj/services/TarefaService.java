package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.exceptions.BadRequestException;
import com.joaolucas.schooljj.exceptions.ResourceNotFoundException;
import com.joaolucas.schooljj.models.dto.TarefaDTO;
import com.joaolucas.schooljj.models.entities.Disciplina;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.models.entities.Tarefa;
import com.joaolucas.schooljj.models.entities.Turma;
import com.joaolucas.schooljj.repositories.DisciplinaRepository;
import com.joaolucas.schooljj.repositories.ProfessorRepository;
import com.joaolucas.schooljj.repositories.TarefaRepository;
import com.joaolucas.schooljj.repositories.TurmaRepository;
import com.joaolucas.schooljj.utils.DataValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final ProfessorRepository professorRepository;
    private final TurmaRepository turmaRepository;

    public List<TarefaDTO> findAll(){
        return tarefaRepository.findAll().stream().map(TarefaDTO::new).toList();
    }

    public TarefaDTO findById(Long id){
        return new TarefaDTO(tarefaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarefa não foi encontrada com ID: " + id)));
    }

    public TarefaDTO create(TarefaDTO tarefaDTO){
        if(!DataValidation.isTarefaDataValid(tarefaDTO)) throw new BadRequestException("Dados da tarefa são inválidos.");
        Disciplina disciplina = disciplinaRepository.findById(tarefaDTO.getDisciplinaId()).orElseThrow(() -> new ResourceNotFoundException("Disciplina não foi encontrada com ID: " + tarefaDTO.getDisciplinaId()));
        Professor professor = professorRepository.findById(tarefaDTO.getProfessorId()).orElseThrow(() -> new ResourceNotFoundException("Professor não foi encontrado com ID: " + tarefaDTO.getProfessorId()));
        Turma turma = turmaRepository.findById(tarefaDTO.getTurmaId()).orElseThrow(() -> new ResourceNotFoundException("Turma não foi encontrada com ID: " + tarefaDTO.getTurmaId()));

        Tarefa tarefa = new Tarefa();
        tarefa.setProfessor(professor);
        tarefa.setDisciplina(disciplina);
        tarefa.setTurma(turma);
        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setProposta(tarefaDTO.getProposta());
        tarefa.setInicio(tarefaDTO.getInicio());
        tarefa.setFim(tarefaDTO.getFim());

        Tarefa savedTarefa = tarefaRepository.save(tarefa);

        disciplina.getTarefas().add(savedTarefa);
        professor.getTarefas().add(savedTarefa);
        turma.getTarefas().add(savedTarefa);

        disciplinaRepository.save(disciplina);
        professorRepository.save(professor);
        turmaRepository.save(turma);

        return new TarefaDTO(savedTarefa);
    }

    public TarefaDTO update(Long id, TarefaDTO tarefaDTO){
        if(!DataValidation.isTarefaDataValid(tarefaDTO)) throw new BadRequestException("Dados da tarefa são inválidos.");

        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarefa não foi encontrada com ID: " + id));

        if(tarefaDTO.getTitulo() != null) tarefa.setTitulo(tarefaDTO.getTitulo());
        if(tarefaDTO.getProposta() != null) tarefa.setProposta(tarefaDTO.getProposta());
        if(tarefaDTO.getInicio() != null) tarefa.setInicio(tarefaDTO.getInicio());
        if(tarefaDTO.getFim() != null) tarefa.setFim(tarefaDTO.getFim());

        return new TarefaDTO(tarefaRepository.save(tarefa));
    }

    public void delete(Long id){
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarefa não foi encontrada com ID: " + id));
        tarefaRepository.delete(tarefa);
    }
}
