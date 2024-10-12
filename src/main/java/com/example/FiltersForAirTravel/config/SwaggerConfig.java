package com.example.FiltersForAirTravel.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Класс конфигурации Swagger для настройки API-документации.
 *
 * <p>Класс отмечен аннотацией {@link Configuration}, что указывает на то,
 * что он содержит определения конфигурационных бинов, используемых в приложении.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Создает настраиваемый объект OpenAPI для документации API.
     *
     * <p>Метод помечен аннотацией {@link Bean}, что означает,
     * что он регистрирует этот метод как бин в Spring-контейнере.
     * Этот бин создает экземпляр {@link OpenAPI}, который настраивает
     * заголовок и описание API для интерфейса Swagger.
     *
     * @return настроенный объект {@link OpenAPI} для документации API
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Flight Filtering API").version("1.0.0").description("API for filtering flights"));
    }
}
