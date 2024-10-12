package com.example.FiltersForAirTravel.utils;

import com.example.FiltersForAirTravel.dto.FlightDTO;
import com.example.FiltersForAirTravel.dto.SegmentDTO;
import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class FlightMapper {
    public FlightDTO toDto(Flight flight) {
        return new FlightDTO(flight.getSegments().stream()
                .map(this::toSegmentDto)
                .collect(Collectors.toList()));
    }

    private SegmentDTO toSegmentDto(Segment segment) {
        return new SegmentDTO(segment.getDepartureDate(), segment.getArrivalDate());
    }
}
