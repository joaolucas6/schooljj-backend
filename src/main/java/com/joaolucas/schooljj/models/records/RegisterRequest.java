package com.joaolucas.schooljj.models.records;

import com.joaolucas.schooljj.models.enums.Role;

public record RegisterRequest(String nome, String sobrenome, String email, String senha, Role role) {
}
