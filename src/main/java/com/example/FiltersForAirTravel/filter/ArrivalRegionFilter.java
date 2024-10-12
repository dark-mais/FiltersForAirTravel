package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalRegionFilter implements FlightFilter {

    private static final Logger logger = LoggerFactory.getLogger(ArrivalRegionFilter.class.getName());
    private final String region;

    public ArrivalRegionFilter(String region) {
        this.region = region;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying ArrivalRegionFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().toString().contains(region)))
                .collect(Collectors.toList());
    }
}