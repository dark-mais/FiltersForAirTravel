package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> filter(List<Flight> flights);
}
