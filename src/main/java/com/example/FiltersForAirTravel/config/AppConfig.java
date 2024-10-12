package com.example.FiltersForAirTravel.config;

import com.example.FiltersForAirTravel.filter.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public CompositeFlightFilter compositeFlightFilter() {
        CompositeFlightFilter compositeFilter = new CompositeFlightFilter();
        List<FlightFilter> filters = configureFilters();
        filters.forEach(compositeFilter::addFilter);
        return compositeFilter;
    }

    @Bean
    public List<FlightFilter> configureFilters() {
        List<FlightFilter> filters = new ArrayList<>();
        filters.add(new DepartureBeforeNowFilter());
        filters.add(new ArrivalBeforeDepartureFilter());
        filters.add(new GroundTimeExceedsTwoHoursFilter());
        filters.add(new MaxStopsFilter(1));
        filters.add(new MinFlightDurationFilter(30)); // Min 30 minutes
        filters.add(new MaxFlightDurationFilter(10 * 60)); // Max 10 hours
        filters.add(new MinSegmentsFilter(2)); // Min 2 segments
        filters.add(new MaxSegmentsFilter(5)); // Max 5 segments
        filters.add(new NightFlightFilter());
        filters.add(new WeekendFlightFilter());
        filters.add(new DateRangeFlightFilter());
        filters.add(new DepartureRegionFilter("Europe"));
        filters.add(new ArrivalRegionFilter("Asia"));
        filters.add(new StopDurationFilter(3 * 60)); // Max stop duration 3 hours
        filters.add(new GroundTimeLimitFilter(120)); // Ground time limit of 120 minutes
        return filters;
    }
}
