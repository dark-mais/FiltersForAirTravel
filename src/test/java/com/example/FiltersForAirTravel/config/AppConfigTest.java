package com.example.FiltersForAirTravel.config;

import com.example.FiltersForAirTravel.filter.FlightFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppConfigTest {

    private AppConfig devConfig;
    private AppConfig prodConfig;

    @BeforeEach
    void setUp() {
        devConfig = new AppConfig("dev");
        prodConfig = new AppConfig("prod");
    }

    @Test
    void testDevConfig() {
        List<FlightFilter> filters = devConfig.configureFilters();
        assertNotNull(filters);
        assertFalse(filters.isEmpty());
        assertEquals(15, filters.size(), "Количество фильтров должно быть равно 15 в конфигурации dev");
    }

    @Test
    void testProdConfig() {
        List<FlightFilter> filters = prodConfig.configureFilters();
        assertNotNull(filters);
        assertFalse(filters.isEmpty());
        assertEquals(15, filters.size(), "Количество фильтров должно быть равно 15 в конфигурации prod");
    }
}
