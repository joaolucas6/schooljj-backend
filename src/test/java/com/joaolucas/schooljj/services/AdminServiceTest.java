package com.joaolucas.schooljj.services;

import com.joaolucas.schooljj.models.dto.AdminDTO;
import com.joaolucas.schooljj.models.entities.Admin;
import com.joaolucas.schooljj.repositories.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {
    @Mock
    private AdminRepository adminRepository;
    private AdminService emTeste;
    private Admin admin;

    @BeforeEach
    void setUp() {
        admin = new Admin();
        emTeste = new AdminService(adminRepository);
    }

    @Test
    void deveRetornarTodosOsAdmins() {
        when(adminRepository.findAll()).thenReturn(List.of(admin));

        var resultado = emTeste.retornarTodos();

        assertThat(resultado).isEqualTo(List.of(new AdminDTO(admin)));
    }

    @Test
    void deveRetornarAdminPorId() {
        when(adminRepository.findById(1L)).thenReturn(Optional.of(admin));

        var resultado = emTeste.retornarPorId(1L);

        assertThat(resultado).isEqualTo(new AdminDTO(admin));
    }

    @Test
    void deveAtualizarAdmin() {
        when(adminRepository.findById(1L)).thenReturn(Optional.of(admin));
        when(adminRepository.save(admin)).thenReturn(admin);

        AdminDTO paraAtualizar = new AdminDTO(admin);
        paraAtualizar.setNome("jojo");

        var resultado = emTeste.atualizar(1L, paraAtualizar);

        assertThat(resultado).isNotNull();
        assertThat(admin.getNome()).isEqualTo("jojo");
    }

    @Test
    void deveDeletarAdmin() {
        when(adminRepository.findById(1L)).thenReturn(Optional.of(admin));

        emTeste.deletar(1L);

        verify(adminRepository, times(1)).delete(admin);
    }
}