package com.example.FiltersForAirTravel.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки конфигурации Swagger.
 *
 * <p>Этот класс содержит тесты для проверки правильности
 * настройки OpenAPI, которая используется для документирования
 * API проекта.
 */
public class SwaggerConfigTest {

    /**
     * Экземпляр класса {@link SwaggerConfig}, используемый для тестирования.
     */
    private SwaggerConfig swaggerConfig;

    /**
     * Метод инициализации перед каждым тестом.
     *
     * <p>Создает новый экземпляр {@link SwaggerConfig} для тестирования.
     */
    @BeforeEach
    void setUp() {
        swaggerConfig = new SwaggerConfig();
    }

    /**
     * Тест для проверки метода {@code customOpenAPI()} в классе {@link SwaggerConfig}.
     *
     * <p>Этот тест проверяет, что метод возвращает не null объект OpenAPI, и что
     * заголовок, версия и описание API настроены правильно.
     */
    @Test
    void testCustomOpenAPI() {
        OpenAPI openAPI = swaggerConfig.customOpenAPI();
        assertNotNull(openAPI, "OpenAPI объект не должен быть null");
        assertEquals("Flight Filtering API", openAPI.getInfo().getTitle(), "Заголовок API не соответствует ожидаемому");
        assertEquals("1.0.0", openAPI.getInfo().getVersion(), "Версия API не соответствует ожидаемой");
        assertEquals("API for filtering flights", openAPI.getInfo().getDescription(), "Описание API не соответствует ожидаемому");
    }
}
