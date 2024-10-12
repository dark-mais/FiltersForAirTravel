package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrivalRegionFilterTest {

    private ArrivalRegionFilter filter;

    @BeforeEach
    void setUp() {
        filter = new ArrivalRegionFilter("Asia");
    }

    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3))));
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(4))));
        List<Flight> flights = List.of(flight1, flight2);

        // Assuming region check is part of some string in segment metadata
        List<Flight> result = filter.filter(flights);
        // This test should fail because metadata with region is not yet implemented
        assertTrue(result.isEmpty());
    }
}
