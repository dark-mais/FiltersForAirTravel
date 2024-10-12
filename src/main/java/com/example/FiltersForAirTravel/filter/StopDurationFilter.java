package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class StopDurationFilter implements FlightFilter {

    private static final Logger logger = LoggerFactory.getLogger(StopDurationFilter.class.getName());
    private final long maxStopDurationInMinutes;

    public StopDurationFilter(long maxStopDurationInMinutes) {
        this.maxStopDurationInMinutes = maxStopDurationInMinutes;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying StopDurationFilter");
        return flights.stream()
                .filter(flight -> calculateTotalStopDuration(flight) <= maxStopDurationInMinutes)
                .collect(Collectors.toList());
    }

    private long calculateTotalStopDuration(Flight flight) {
        long totalStopDuration = 0;
        List<Segment> segments = flight.getSegments();
        for (int i = 1; i < segments.size(); i++) {
            Segment previousSegment = segments.get(i - 1);
            Segment currentSegment = segments.get(i);
            totalStopDuration += java.time.Duration.between(previousSegment.getArrivalDate(), currentSegment.getDepartureDate()).toMinutes();
        }
        return totalStopDuration;
    }
}