package ru.tinkoff.studentservice.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun publicUserApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("University")
            .pathsToMatch("/**")
            .build()
    }

    @Bean
    fun customOpenApi(): OpenAPI? {
        return OpenAPI().info(
            Info().title("Student service")
        )
    }
}