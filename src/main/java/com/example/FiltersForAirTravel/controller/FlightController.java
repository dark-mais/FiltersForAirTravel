package com.example.FiltersForAirTravel.controller;

import com.example.FiltersForAirTravel.dto.FlightDTO;
import com.example.FiltersForAirTravel.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private static final Logger logger = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    private FlightService flightService;

    @Operation(summary = "Получить отфильтрованные авиаперелеты")
    @GetMapping("/filtered")
    @Cacheable("filteredFlights")
    public DeferredResult<List<FlightDTO>> getFilteredFlights() {
        logger.info("Fetching filtered flights...");
        DeferredResult<List<FlightDTO>> output = new DeferredResult<>();
        CompletableFuture<List<FlightDTO>> future = flightService.getFilteredFlights();
        future.thenAccept(output::setResult);
        return output;
    }
}
