package com.nit.main.config;

import org.springdoc.core.*;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .packagesToScan("com.nit.main.controller") // Package to scan for controllers
                .pathsToMatch("/**") // Match all endpoints
                .build();
    }
}