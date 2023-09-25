package com.joaolucas.schooljj.config;

import com.joaolucas.schooljj.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final SecurityFilter securityFilter;
    private final UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth

                    .requestMatchers("/api/v1/autenticacao/**")
                    .hasRole("ADMINISTRADOR")

                    .requestMatchers("/api/v1/turmas/**")
                    .hasRole("ADMINISTRADOR")


                    .requestMatchers(HttpMethod.GET, "/api/v1/tarefas")
                    .authenticated()

                    .requestMatchers(HttpMethod.POST, "/api/v1/tarefas")
                    .hasAnyRole("PROFESSOR", "ADMINISTRADOR")

                    .requestMatchers(HttpMethod.PUT, "/api/v1/tarefas")
                    .hasAnyRole("PROFESSOR", "ADMINISTRADOR")

                    .requestMatchers(HttpMethod.DELETE, "/api/v1/tarefas")
                    .hasAnyRole("PROFESSOR", "ADMINISTRADOR")

                    .requestMatchers(HttpMethod.PUT, "/api/v1/professores")
                    .hasRole("ADMINISTRADOR")

                    .requestMatchers(HttpMethod.DELETE, "/api/v1/professores")
                    .hasRole("ADMINISTRADOR")



                    .requestMatchers(HttpMethod.POST, "/api/v1/notas")
                    .hasAnyRole("PROFESSOR", "ADMINISTRADOR")

                    .requestMatchers(HttpMethod.PUT, "/api/v1/notas")
                    .hasAnyRole("PROFESSOR", "ADMINISTRADOR")

                    .requestMatchers(HttpMethod.DELETE, "/api/v1/notas")
                    .hasAnyRole("PROFESSOR", "ADMINISTRADOR")


                    .requestMatchers(HttpMethod.POST, "/api/v1/disciplinas")
                    .hasRole("ADMINISTRADOR")

                    .requestMatchers(HttpMethod.PUT, "/api/v1/disciplinas")
                    .hasRole("ADMINISTRADOR")

                    .requestMatchers(HttpMethod.DELETE, "/api/v1/disciplinas")
                    .hasRole("ADMINISTRADOR")

                    .requestMatchers(HttpMethod.PUT, "/api/v1/alunos")
                    .hasRole("ADMINISTRADOR")

                    .requestMatchers(HttpMethod.DELETE, "/api/v1/alunos")
                    .hasRole("ADMINISTRADOR")

                    .requestMatchers("/api/v1/admins/**")
                    .hasRole("ADMINISTRADOR")

                    .anyRequest()
                    .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider())
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
