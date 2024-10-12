package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class MaxFlightDurationFilter implements FlightFilter {

    private static final Logger logger = LoggerFactory.getLogger(MaxFlightDurationFilter.class.getName());
    private final long maxDurationInMinutes;

    public MaxFlightDurationFilter(long maxDurationInMinutes) {
        this.maxDurationInMinutes = maxDurationInMinutes;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying MaxFlightDurationFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> java.time.Duration.between(segment.getDepartureDate(), segment.getArrivalDate()).toMinutes() <= maxDurationInMinutes))
                .collect(Collectors.toList());
    }
}
