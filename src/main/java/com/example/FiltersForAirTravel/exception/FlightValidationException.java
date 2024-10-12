package com.example.FiltersForAirTravel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FlightValidationException extends RuntimeException {
    public FlightValidationException(String message) {
        super(message);
    }
}
