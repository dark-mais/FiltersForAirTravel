package com.example.FiltersForAirTravel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Глобальный обработчик исключений для всего приложения.
 *
 * <p>Аннотирован как {@link ControllerAdvice}, что указывает на его роль
 * в перехвате исключений на уровне всего приложения. Обрабатывает общие исключения,
 * предоставляя стандартный ответ при возникновении ошибок.
 *
 * <p>Класс наследует {@link RuntimeException}, что позволяет обрабатывать необработанные
 * исключения во время выполнения программы.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    /**
     * Логгер для записи ошибок в лог.
     *
     * <p>Используется для логирования ошибок с уровнем "error" при возникновении
     * исключений.
     */
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Метод для обработки общих исключений в приложении.
     *
     * <p>Метод аннотирован {@link ExceptionHandler}, что означает его использование
     * для перехвата и обработки исключений типа {@link Exception}. Логирует сообщение
     * об ошибке и возвращает стандартный ответ с HTTP статусом 500.
     *
     * @param ex перехваченное исключение
     * @return объект {@link ResponseEntity}, содержащий сообщение об ошибке
     *         и статус HTTP 500 (Internal Server Error)
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        logger.error("Global error: {}", ex.getMessage());
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
