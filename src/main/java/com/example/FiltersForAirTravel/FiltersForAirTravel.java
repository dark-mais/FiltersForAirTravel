package com.example.FiltersForAirTravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Главный класс приложения FiltersForAirTravel.
 *
 * <p>Отмечен аннотациями:
 * <ul>
 *     <li>{@link SpringBootApplication} - обозначает, что это Spring Boot приложение, которое включает автоматическую конфигурацию, сканирование компонентов и настройку Beans.</li>
 *     <li>{@link EnableCaching} - включает кэширование в приложении для оптимизации производительности при работе с данными.</li>
 *     <li>{@link EnableAsync} - позволяет использовать асинхронное выполнение методов в приложении, улучшая многозадачность.</li>
 * </ul>
 *
 * <p>Основная функция этого класса — инициализация и запуск Spring Boot приложения с помощью метода {@link SpringApplication#run(Class, String[])}.
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
public class FiltersForAirTravel {

    /**
     * Главный метод для запуска Spring Boot приложения.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(FiltersForAirTravel.class, args);
    }
}
