package com.joaolucas.schooljj.utils;

import com.joaolucas.schooljj.models.dto.*;
import com.joaolucas.schooljj.models.entities.Professor;
import com.joaolucas.schooljj.models.entities.Turma;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class DataValidation {

    public static boolean isUserDataValid(AlunoDTO alunoDTO){
        if(isAllFieldsNull(alunoDTO)) return false;
        if(alunoDTO.getNome() != null && alunoDTO.getNome().isBlank() || alunoDTO.getNome().length() > 50) return false;
        if(alunoDTO.getSobrenome() != null && alunoDTO.getSobrenome().isBlank() || alunoDTO.getSobrenome() != null && alunoDTO.getSobrenome().length() > 50) return false;
        if(alunoDTO.getEmail() != null && !isEmailValid(alunoDTO.getEmail())) return false;
        if(alunoDTO.getCpf() != null && !isCpfValid(alunoDTO.getCpf())) return false;
        if(alunoDTO.getDataNascimento() != null && alunoDTO.getDataNascimento().isAfter(LocalDate.now())) return false;
        if(alunoDTO.getNumeroTelefone() != null && alunoDTO.getNumeroTelefone().length() != 9 || alunoDTO.getNumeroTelefone() != null &&  alunoDTO.getNumeroTelefone().isBlank()) return false;

        return true;
    }

    public static boolean isUserDataValid(ProfessorDTO professorDTO){
        if(isAllFieldsNull(professorDTO)) return false;
        if(professorDTO.getNome() != null && professorDTO.getNome().isBlank() || professorDTO.getNome() != null & professorDTO.getNome().length() > 50) return false;
        if(professorDTO.getSobrenome() != null && professorDTO.getSobrenome().isBlank() || professorDTO.getSobrenome() != null && professorDTO.getSobrenome().length() > 50) return false;
        if(professorDTO.getEmail() != null && !isEmailValid(professorDTO.getEmail())) return false;
        if(professorDTO.getCpf() != null && !isCpfValid(professorDTO.getCpf())) return false;
        if(professorDTO.getDataNascimento() != null && professorDTO.getDataNascimento().isAfter(LocalDate.now())) return false;
        if(professorDTO.getNumeroTelefone() != null && professorDTO.getNumeroTelefone().length() != 9 || professorDTO.getNumeroTelefone() != null && professorDTO.getNumeroTelefone().isBlank()) return false;

        return true;
    }

    public static boolean isUserDataValid(AdminDTO adminDTO){
        if(isAllFieldsNull(adminDTO)) return false;
        if(adminDTO.getNome().isBlank() || adminDTO.getNome().length() > 50) return false;
        if(adminDTO.getSobrenome().isBlank() || adminDTO.getSobrenome().length() > 50) return false;
        if(!isEmailValid(adminDTO.getEmail())) return false;
        if(!isCpfValid(adminDTO.getCpf())) return false;
        if(adminDTO.getDataNascimento().isAfter(LocalDate.now())) return false;
        if(adminDTO.getNumeroTelefone().length() != 9 || adminDTO.getNumeroTelefone().isBlank()) return false;

        return true;
    }

    public static boolean isDisciplinaDataValid(DisciplinaDTO disciplinaDTO){
        if(isAllFieldsNull(disciplinaDTO)) return false;
        if(disciplinaDTO.getNome() != null && disciplinaDTO.getNome().isBlank() || disciplinaDTO.getNome() != null && disciplinaDTO.getNome().length() > 35) return false;
        if(disciplinaDTO.getDescricao() != null && disciplinaDTO.getDescricao().length() > 500 || disciplinaDTO.getDescricao() != null && disciplinaDTO.getDescricao().isBlank()) return false;
        return true;
    }

    public static boolean isNotaDataValid(NotaDTO notaDTO){
        if(isAllFieldsNull(notaDTO)) return false;
        if(notaDTO.getNota() != null && notaDTO.getNota() < 0 || notaDTO.getNota() != null && notaDTO.getNota() > 10) return false;
        if(notaDTO.getObservacoes() != null && notaDTO.getObservacoes().isBlank() || notaDTO.getObservacoes() != null && notaDTO.getObservacoes().length() > 3000) return false;
        return true;
    }

    public static boolean isRespostaDataValid(RespostaDTO respostaDTO){
        if(isAllFieldsNull(respostaDTO)) return false;
        if(respostaDTO.getTexto() != null && respostaDTO.getTexto().isBlank() || respostaDTO.getTexto() != null &&  respostaDTO.getTexto().length() > 3000) return false;

        return true;
    }

    public static boolean isTarefaDataValid(TarefaDTO tarefaDTO){
        if(isAllFieldsNull(tarefaDTO)) return false;
        if(tarefaDTO.getTitulo() != null && tarefaDTO.getTitulo().isBlank() || tarefaDTO.getTitulo() != null && tarefaDTO.getTitulo().length() > 200) return false;
        if(tarefaDTO.getProposta() != null && tarefaDTO.getProposta().isBlank() || tarefaDTO.getProposta() != null && tarefaDTO.getProposta().length() > 1300) return false;
        if(tarefaDTO.getInicio() != null && tarefaDTO.getInicio().isAfter(tarefaDTO.getFim())) return false;
        if(tarefaDTO.getFim() != null && tarefaDTO.getFim().isBefore(LocalDateTime.now())) return false;

        return true;
    }

    public static boolean isTurmaDataValid(TurmaDTO turmaDTO){
        if(isAllFieldsNull(turmaDTO)) return false;
        if(turmaDTO.getNome() != null && turmaDTO.getNome().isBlank() || turmaDTO.getNome() != null &&  turmaDTO.getNome().length() > 50) return false;

        return true;
    }

    public static boolean isCpfValid(String value){
        String cpf = value.replace(".", "").replace("-", "");

        String firstPart = cpf.substring(0, 9);

        int firstPartResult = 0;

        for(int i = 10, j = 0; i >= 2; i--, j++){
            int number = Integer.parseInt(String.valueOf(firstPart.charAt(j)));

            number *= i;
            firstPartResult += number;
        }

        if(firstPartResult * 10 % 11 !=  Integer.parseInt(String.valueOf(cpf.charAt(9)))) return false;

        int secondPartResult = 0;

        for(int i = 11, j = 0; i >= 2; i--, j++){

            int number = Integer.parseInt(String.valueOf(cpf.charAt(j)));

            number *= i;
            secondPartResult += number;
        }

        if(secondPartResult * 10 % 11 != Integer.parseInt(String.valueOf(cpf.charAt(10)))) return false;

        return true;
    }

    public static boolean isEmailValid(String email){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        return pattern.matcher(email).matches();
    }

    public static boolean isAllFieldsNull(Object object){
        Class<?> objectClass = object.getClass();
        for(Field field : objectClass.getFields()){
            if(field == null) return true;
        }

        return false;
    }
}
