package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSegmentsFilter implements FlightFilter {

    private static final Logger logger = LoggerFactory.getLogger(MaxSegmentsFilter.class.getName());
    private final int maxSegments;

    public MaxSegmentsFilter(int maxSegments) {
        this.maxSegments = maxSegments;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying MaxSegmentsFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().size() <= maxSegments)
                .collect(Collectors.toList());
    }
}
