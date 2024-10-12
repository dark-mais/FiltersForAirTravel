package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DateRangeFlightFilter implements FlightFilter {

    private static final Logger logger = LoggerFactory.getLogger(DateRangeFlightFilter.class.getName());

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying DateRangeFlightFilter");
        LocalDate minDate = LocalDate.of(2024, 1, 1);
        LocalDate maxDate = LocalDate.of(2025, 12, 31);
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> isInRange(segment, minDate, maxDate)))
                .collect(Collectors.toList());
    }

    private boolean isInRange(Segment segment, LocalDate minDate, LocalDate maxDate) {
        LocalDate departureDate = segment.getDepartureDate().toLocalDate();
        return (departureDate.isEqual(minDate) || departureDate.isAfter(minDate))
                && (departureDate.isEqual(maxDate) || departureDate.isBefore(maxDate));
    }
}