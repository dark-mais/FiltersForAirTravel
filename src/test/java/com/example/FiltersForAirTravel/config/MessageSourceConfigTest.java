package com.example.FiltersForAirTravel.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки конфигурации {@link MessageSourceConfig}.
 *
 * <p>Проверяет правильность создания и работы бина {@link MessageSource} для
 * различных локалей.
 */
class MessageSourceConfigTest {

    /**
     * Экземпляр конфигурационного класса для тестирования.
     */
    private MessageSourceConfig messageSourceConfig;

    /**
     * Настраивает окружение перед каждым тестом.
     *
     * <p>Создаёт новый экземпляр {@link MessageSourceConfig}.
     */
    @BeforeEach
    void setUp() {
        messageSourceConfig = new MessageSourceConfig();
    }

    /**
     * Тестирует метод {@link MessageSourceConfig#messageSource()}.
     *
     * <p>Проверяет, что бин {@link MessageSource} не null и корректно загружает
     * сообщения для различных локалей. Для этого выполняются тесты по умолчанию
     * для английской локали, а также проверка французской локализации.
     */
    @Test
    void testMessageSource() {
        MessageSource messageSource = messageSourceConfig.messageSource();
        assertNotNull(messageSource);

        // Проверка загрузки сообщения для английского по умолчанию
        String message = messageSource.getMessage("message.key", null, Locale.ENGLISH);
        assertEquals("Expected message", message);

        // Проверка загрузки сообщения для локали
        LocaleContextHolder.setLocale(Locale.FRENCH);
        String frenchMessage = messageSource.getMessage("message.key", null, Locale.FRENCH);
        assertEquals("French message", frenchMessage);
    }
}
