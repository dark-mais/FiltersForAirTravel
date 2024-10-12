package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.stream.Collectors;

public class MaxStopsFilter implements FlightFilter {

    private static final Logger logger = LoggerFactory.getLogger(MaxStopsFilter.class.getName());
    private final int maxStops;

    public MaxStopsFilter(int maxStops) {
        this.maxStops = maxStops;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying MaxStopsFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().size() <= maxStops + 1)
                .collect(Collectors.toList());
    }
}
