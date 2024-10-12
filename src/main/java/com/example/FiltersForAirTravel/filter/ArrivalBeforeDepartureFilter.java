package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDepartureFilter implements FlightFilter {

    private static final Logger logger = LoggerFactory.getLogger(ArrivalBeforeDepartureFilter.class.getName());

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying ArrivalBeforeDepartureFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
