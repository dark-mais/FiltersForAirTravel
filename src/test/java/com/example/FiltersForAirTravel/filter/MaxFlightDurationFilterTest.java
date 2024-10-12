package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxFlightDurationFilterTest {

    private MaxFlightDurationFilter filter;

    @BeforeEach
    void setUp() {
        filter = new MaxFlightDurationFilter(120); // Max 2 hours
    }

    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusMinutes(180))));
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusMinutes(90))));
        List<Flight> flights = List.of(flight1, flight2);

        List<Flight> result = filter.filter(flights);
        assertEquals(1, result.size());
        assertEquals(flight2, result.get(0));
    }
}
