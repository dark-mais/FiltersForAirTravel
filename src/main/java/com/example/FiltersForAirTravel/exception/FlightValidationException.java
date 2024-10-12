package com.example.FiltersForAirTravel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Исключение, выбрасываемое в случае нарушения правил валидации полетов.
 *
 * <p>Отмечено аннотацией {@link ResponseStatus} с кодом ошибки {@link HttpStatus#BAD_REQUEST},
 * что означает, что при выбрасывании этого исключения клиенту будет возвращен статус HTTP 400 (Bad Request).
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FlightValidationException extends RuntimeException {

    /**
     * Конструктор исключения {@code FlightValidationException}, принимающий сообщение об ошибке.
     *
     * @param message сообщение, описывающее причину ошибки валидации
     */
    public FlightValidationException(String message) {
        super(message);
    }
}
