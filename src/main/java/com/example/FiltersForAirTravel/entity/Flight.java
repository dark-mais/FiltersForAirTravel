package com.example.FiltersForAirTravel.entity;

import java.util.Collections;
import java.util.List;

public class Flight {
    private final List<Segment> segments;

    public Flight(List<Segment> segments) {
        this.segments = Collections.unmodifiableList(segments);
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.toString();
    }
}
