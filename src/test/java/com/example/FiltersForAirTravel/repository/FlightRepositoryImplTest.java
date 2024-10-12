package com.example.FiltersForAirTravel.repository;

import com.example.FiltersForAirTravel.entity.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Repository
class FlightRepositoryImplTest {

    private FlightRepositoryImpl flightRepository;

    @BeforeEach
    void setUp() {
        flightRepository = new FlightRepositoryImpl();
    }

    @Test
    void testGetAllFlights() {
        List<Flight> flights = flightRepository.getAllFlights();
        assertNotNull(flights);
        assertFalse(flights.isEmpty());
    }
}
