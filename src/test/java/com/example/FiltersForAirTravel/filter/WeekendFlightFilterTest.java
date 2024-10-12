package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeekendFlightFilterTest {

    private WeekendFlightFilter filter;

    @BeforeEach
    void setUp() {
        filter = new WeekendFlightFilter();
    }

    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.of(2023, 1, 7, 10, 0), LocalDateTime.of(2023, 1, 7, 12, 0)))); // Saturday
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.of(2023, 1, 6, 10, 0), LocalDateTime.of(2023, 1, 6, 12, 0)))); // Friday
        List<Flight> flights = List.of(flight1, flight2);

        List<Flight> result = filter.filter(flights);
        assertEquals(1, result.size());
        assertEquals(flight2, result.get(0));
    }
}
