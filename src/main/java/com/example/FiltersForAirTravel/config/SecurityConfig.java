package com.example.FiltersForAirTravel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Класс {@code SecurityConfig} предоставляет конфигурацию безопасности для приложения.
 *
 * <p>Аннотация {@link Configuration} указывает, что данный класс содержит определения
 * бинов для контекста Spring. Данный класс конфигурирует параметры безопасности,
 * включая отключение CSRF и настройку правил авторизации для запросов.
 */
@Configuration
public class SecurityConfig {

    /**
     * Определяет цепочку фильтров безопасности для обработки HTTP-запросов.
     *
     * <p>Метод помечен аннотацией {@link Bean}, что означает создание и
     * добавление этого метода в контекст Spring в качестве бина.
     *
     * <p>Конфигурация включает:
     * <ul>
     *     <li>Отключение CSRF-защиты для упрощения работы с API.</li>
     *     <li>Авторизацию всех запросов к URI, начинающимся с "/api/**", требующую
     *     аутентификации.</li>
     *     <li>Разрешение всех остальных запросов без необходимости аутентификации.</li>
     *     <li>Использование базовой аутентификации HTTP.</li>
     * </ul>
     *
     * @param http объект {@link HttpSecurity}, используемый для настройки безопасности HTTP-запросов
     * @return объект {@link SecurityFilterChain}, содержащий настроенную цепочку фильтров безопасности
     * @throws Exception если возникает ошибка при настройке безопасности
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Отключение CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").authenticated()  // Новая версия метода
                        .anyRequest().permitAll())
                .httpBasic(withDefaults());
        return http.build();
    }
}
