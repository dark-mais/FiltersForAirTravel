package com.example.FiltersForAirTravel.dto;

import java.util.List;

public class FlightDTO {
    private List<SegmentDTO> segments;

    public FlightDTO(List<SegmentDTO> segments) {
        this.segments = segments;
    }

    public List<SegmentDTO> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return "FlightDTO{" +
                "segments=" + segments +
                '}';
    }
}
