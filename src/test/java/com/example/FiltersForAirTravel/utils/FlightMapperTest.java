package com.example.FiltersForAirTravel.utils;

import com.example.FiltersForAirTravel.dto.FlightDTO;
import com.example.FiltersForAirTravel.dto.SegmentDTO;
import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightMapperTest {

    private FlightMapper flightMapper;

    @BeforeEach
    void setUp() {
        flightMapper = new FlightMapper();
    }

    @Test
    void testToDto() {
        // Setup a flight with one segment
        Segment segment = new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        Flight flight = new Flight(List.of(segment));

        // Convert to DTO
        FlightDTO flightDTO = flightMapper.toDto(flight);

        // Assert correctness
        assertNotNull(flightDTO);
        assertEquals(1, flightDTO.getSegments().size());

        SegmentDTO segmentDTO = flightDTO.getSegments().get(0);
        assertEquals(segment.getDepartureDate(), segmentDTO.getDepartureDate());
        assertEquals(segment.getArrivalDate(), segmentDTO.getArrivalDate());
    }

    @Test
    void testEmptyFlightToDto() {
        // Setup an empty flight
        Flight flight = new Flight(List.of());

        // Convert to DTO
        FlightDTO flightDTO = flightMapper.toDto(flight);

        // Assert correctness
        assertNotNull(flightDTO);
        assertTrue(flightDTO.getSegments().isEmpty());
    }
}
