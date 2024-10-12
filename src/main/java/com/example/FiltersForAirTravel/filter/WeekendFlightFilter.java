package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class WeekendFlightFilter implements FlightFilter {

    private static final Logger logger = LoggerFactory.getLogger(WeekendFlightFilter.class.getName());

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying WeekendFlightFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> !isWeekendFlight(segment)))
                .collect(Collectors.toList());
    }

    private boolean isWeekendFlight(Segment segment) {
        int dayOfWeek = segment.getDepartureDate().getDayOfWeek().getValue();
        return dayOfWeek == 6 || dayOfWeek == 7; // Saturday or Sunday
    }
}
