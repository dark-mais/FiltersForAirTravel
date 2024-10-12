package com.example.FiltersForAirTravel.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки поведения {@link GlobalExceptionHandler}.
 *
 * <p>Этот класс проверяет корректную обработку исключений глобальным обработчиком
 * исключений в приложении.
 *
 * <p>Тестируются такие аспекты, как:
 * <ul>
 *   <li>Корректность возвращаемого ответа</li>
 *   <li>Статус HTTP ответа</li>
 *   <li>Содержимое тела ответа</li>
 * </ul>
 */
public class GlobalExceptionHandlerTest {

    /**
     * Экземпляр {@code GlobalExceptionHandler}, который будет использоваться для тестирования.
     */
    private GlobalExceptionHandler globalExceptionHandler;

    /**
     * Метод, выполняемый перед каждым тестом для инициализации экземпляра {@link GlobalExceptionHandler}.
     */
    @BeforeEach
    void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    /**
     * Тест проверяет корректность обработки общего исключения.
     *
     * <p>Проверяется, что метод {@code handleException} возвращает корректный ответ с кодом
     * {@link HttpStatus#INTERNAL_SERVER_ERROR} и соответствующим сообщением в теле ответа.
     */
    @Test
    void testHandleException() {
        Exception exception = new Exception("Test Exception");
        ResponseEntity<String> response = globalExceptionHandler.handleException(exception);

        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal server error", response.getBody());
    }
}
