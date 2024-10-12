package com.example.FiltersForAirTravel.entity;

import java.time.LocalDateTime;

public class Segment {
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;

    public Segment(LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return "[Departure: " + departureDate +
                ", Arrival: " + arrivalDate + "]";
    }
}
