package com.joaolucas.schooljj.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(new Info()
                .title("DramaJJ API")
                .description("A Spring boot application for a dramas review website")
                .version("v1")
        );
    }
}
