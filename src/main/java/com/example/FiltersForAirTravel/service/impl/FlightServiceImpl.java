package com.example.FiltersForAirTravel.service.impl;

import com.example.FiltersForAirTravel.dto.FlightDTO;
import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.filter.CompositeFlightFilter;
import com.example.FiltersForAirTravel.repository.FlightRepository;
import com.example.FiltersForAirTravel.utils.FlightMapper;
import com.example.FiltersForAirTravel.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {
    private static final Logger logger = LoggerFactory.getLogger(FlightServiceImpl.class);

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private CompositeFlightFilter flightFilter;

    @Autowired
    private FlightMapper flightMapper;

    @Override
    @Async
    @Cacheable("filteredFlights")
    public CompletableFuture<List<FlightDTO>> getFilteredFlights() {
        logger.info("Fetching and filtering flights asynchronously");
        List<Flight> flights = flightRepository.getAllFlights();
        List<Flight> filteredFlights = flightFilter.filter(flights);
        List<FlightDTO> result = filteredFlights.stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(result);
    }
}
