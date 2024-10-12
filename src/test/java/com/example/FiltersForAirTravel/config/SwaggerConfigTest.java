package com.example.FiltersForAirTravel.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwaggerConfigTest {

    private SwaggerConfig swaggerConfig;

    @BeforeEach
    void setUp() {
        swaggerConfig = new SwaggerConfig();
    }

    @Test
    void testCustomOpenAPI() {
        OpenAPI openAPI = swaggerConfig.customOpenAPI();
        assertNotNull(openAPI);
        assertEquals("Flight Filtering API", openAPI.getInfo().getTitle());
        assertEquals("1.0.0", openAPI.getInfo().getVersion());
        assertEquals("API for filtering flights", openAPI.getInfo().getDescription());
    }
}
