package com.example.FiltersForAirTravel.service;

import com.example.FiltersForAirTravel.dto.FlightDTO;
import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.filter.CompositeFlightFilter;
import com.example.FiltersForAirTravel.repository.FlightRepository;
import com.example.FiltersForAirTravel.service.impl.FlightServiceImpl;
import com.example.FiltersForAirTravel.utils.FlightMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Service
class FlightServiceImplTest {

    @InjectMocks
    private FlightServiceImpl flightService;

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private CompositeFlightFilter flightFilter;

    @Mock
    private FlightMapper flightMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFilteredFlights() throws Exception {
        // Setup mock behavior
        List<Flight> flights = Collections.emptyList();
        when(flightRepository.getAllFlights()).thenReturn(flights);
        when(flightFilter.filter(flights)).thenReturn(flights);
        when(flightMapper.toDto(any())).thenReturn(new FlightDTO(Collections.emptyList()));

        // Execute service method
        CompletableFuture<List<FlightDTO>> result = flightService.getFilteredFlights();

        // Verify result
        assertNotNull(result);
        assertTrue(result.get().isEmpty());
        verify(flightRepository).getAllFlights();
        verify(flightFilter).filter(flights);
    }
}
