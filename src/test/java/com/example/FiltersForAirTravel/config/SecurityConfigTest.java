package com.example.FiltersForAirTravel.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки конфигурации безопасности {@link SecurityConfig}.
 *
 * <p>Этот класс содержит тесты для проверки корректности настроек фильтрации безопасности
 * с помощью метода {@code securityFilterChain()}.
 */
class SecurityConfigTest {

    /**
     * Конфигурация безопасности, используемая в тестах.
     */
    private SecurityConfig securityConfig;

    /**
     * Инициализация объекта конфигурации безопасности перед каждым тестом.
     *
     * <p>Этот метод вызывается перед выполнением каждого теста для создания нового
     * экземпляра {@link SecurityConfig}.
     */
    @BeforeEach
    void setUp() {
        securityConfig = new SecurityConfig();
    }

    /**
     * Тест проверяет, что метод {@code securityFilterChain()} возвращает
     * не null объект фильтра безопасности.
     *
     * <p>Метод создает объект {@link HttpSecurity} и передает его в {@link SecurityConfig#securityFilterChain(HttpSecurity)}.
     * Тест проверяет, что результат работы метода не является {@code null}.
     *
     * @throws Exception если возникает ошибка в процессе настройки {@link HttpSecurity}.
     */
    @Test
    void testSecurityFilterChain() throws Exception {
        HttpSecurity httpSecurity = new HttpSecurity(null, null, null);
        SecurityFilterChain filterChain = securityConfig.securityFilterChain(httpSecurity);
        assertNotNull(filterChain);
    }
}
