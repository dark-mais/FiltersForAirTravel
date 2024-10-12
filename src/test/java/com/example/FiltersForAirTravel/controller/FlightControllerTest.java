package com.example.FiltersForAirTravel.controller;

import com.example.FiltersForAirTravel.dto.FlightDTO;
import com.example.FiltersForAirTravel.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FlightControllerTest {

    @InjectMocks
    private FlightController flightController;

    @Mock
    private FlightService flightService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFilteredFlights() {
        // Setup mock behavior
        when(flightService.getFilteredFlights()).thenReturn(CompletableFuture.completedFuture(Collections.emptyList()));

        // Execute controller method
        DeferredResult<List<FlightDTO>> result = flightController.getFilteredFlights();

        // Verify result
        assertNotNull(result);
        assertTrue(result.getResult().isEmpty());
    }
}
