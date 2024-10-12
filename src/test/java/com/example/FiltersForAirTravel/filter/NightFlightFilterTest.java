package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NightFlightFilterTest {

    private NightFlightFilter filter;

    @BeforeEach
    void setUp() {
        filter = new NightFlightFilter();
    }

    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.of(2023, 1, 1, 3, 0), LocalDateTime.of(2023, 1, 1, 5, 0))));
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.of(2023, 1, 1, 8, 0), LocalDateTime.of(2023, 1, 1, 10, 0))));
        List<Flight> flights = List.of(flight1, flight2);

        List<Flight> result = filter.filter(flights);
        assertEquals(1, result.size());
        assertEquals(flight2, result.get(0));
    }
}
