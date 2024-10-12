package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CompositeFlightFilter implements FlightFilter {
    private static final Logger logger = LoggerFactory.getLogger(CompositeFlightFilter.class.getName());
    private final List<FlightFilter> filters = new ArrayList<>();

    public void addFilter(FlightFilter filter) {
        filters.add(filter);
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying composite filters");
        List<Flight> result = new ArrayList<>(flights);
        for (FlightFilter filter : filters) {
            result = filter.filter(result);
        }
        return result;
    }
}
