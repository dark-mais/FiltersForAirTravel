package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class MinFlightDurationFilter implements FlightFilter {

    private static final Logger logger = LoggerFactory.getLogger(MinFlightDurationFilter.class.getName());
    private final long minDurationInMinutes;

    public MinFlightDurationFilter(long minDurationInMinutes) {
        this.minDurationInMinutes = minDurationInMinutes;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying MinFlightDurationFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> java.time.Duration.between(segment.getDepartureDate(), segment.getArrivalDate()).toMinutes() >= minDurationInMinutes))
                .collect(Collectors.toList());
    }
}
