package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DateRangeFlightFilterTest {

    private DateRangeFlightFilter filter;

    @BeforeEach
    void setUp() {
        filter = new DateRangeFlightFilter();
    }

    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.of(2023, 12, 31, 10, 0), LocalDateTime.of(2023, 12, 31, 12, 0))));
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.of(2024, 6, 15, 10, 0), LocalDateTime.of(2024, 6, 15, 12, 0))));
        List<Flight> flights = List.of(flight1, flight2);

        List<Flight> result = filter.filter(flights);
        assertEquals(1, result.size());
        assertEquals(flight2, result.get(0));
    }
}
