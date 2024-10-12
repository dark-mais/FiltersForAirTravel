package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class GroundTimeExceedsTwoHoursFilter implements FlightFilter {

    private static final Logger logger = LoggerFactory.getLogger(GroundTimeExceedsTwoHoursFilter.class.getName());

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying GroundTimeExceedsTwoHoursFilter");
        return flights.stream()
                .filter(flight -> calculateTotalGroundTime(flight) <= 120)
                .collect(Collectors.toList());
    }

    private long calculateTotalGroundTime(Flight flight) {
        long totalGroundTime = 0;
        List<Segment> segments = flight.getSegments();
        for (int i = 1; i < segments.size(); i++) {
            Segment previousSegment = segments.get(i - 1);
            Segment currentSegment = segments.get(i);
            totalGroundTime += java.time.Duration.between(previousSegment.getArrivalDate(), currentSegment.getDepartureDate()).toMinutes();
        }
        return totalGroundTime;
    }
}
