package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartureBeforeNowFilterTest {

    private DepartureBeforeNowFilter filter;

    @BeforeEach
    void setUp() {
        filter = new DepartureBeforeNowFilter();
    }

    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(2))));
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2))));
        List<Flight> flights = List.of(flight1, flight2);

        List<Flight> result = filter.filter(flights);
        assertEquals(1, result.size());
        assertEquals(flight2, result.get(0));
    }
}
