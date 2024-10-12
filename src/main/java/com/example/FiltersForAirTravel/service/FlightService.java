package com.example.FiltersForAirTravel.service;

import com.example.FiltersForAirTravel.dto.FlightDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface FlightService {
    CompletableFuture<List<FlightDTO>> getFilteredFlights();
}
