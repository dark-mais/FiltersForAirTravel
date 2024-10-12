package com.example.FiltersForAirTravel.dto;

import java.time.LocalDateTime;

public class SegmentDTO {
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

    public SegmentDTO(LocalDateTime departureDate, LocalDateTime arrivalDate) {
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
        return "SegmentDTO{" +
                "departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
