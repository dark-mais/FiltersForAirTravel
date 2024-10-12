package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class MinSegmentsFilter implements FlightFilter {

    private static final Logger logger = LoggerFactory.getLogger(MinSegmentsFilter.class.getName());
    private final int minSegments;

    public MinSegmentsFilter(int minSegments) {
        this.minSegments = minSegments;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying MinSegmentsFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().size() >= minSegments)
                .collect(Collectors.toList());
    }
}
