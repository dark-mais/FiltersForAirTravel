package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class NightFlightFilter implements FlightFilter {

    private static final Logger logger = LoggerFactory.getLogger(NightFlightFilter.class.getName());

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying NightFlightFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> isNotNightFlight(segment)))
                .collect(Collectors.toList());
    }

    private boolean isNotNightFlight(Segment segment) {
        int hourOfDeparture = segment.getDepartureDate().getHour();
        return hourOfDeparture >= 6 && hourOfDeparture <= 22; // Not a night flight
    }
}
