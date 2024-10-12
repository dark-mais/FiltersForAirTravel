package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class DepartureRegionFilter implements FlightFilter {

    private static final Logger logger = LoggerFactory.getLogger(DepartureRegionFilter.class.getName());
    private final String region;

    public DepartureRegionFilter(String region) {
        this.region = region;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying DepartureRegionFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().toString().contains(region)))
                .collect(Collectors.toList());
    }
}
