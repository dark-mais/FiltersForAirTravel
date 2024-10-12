package com.example.FiltersForAirTravel.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.junit.jupiter.api.Assertions.*;

class SecurityConfigTest {

    private SecurityConfig securityConfig;

    @BeforeEach
    void setUp() {
        securityConfig = new SecurityConfig();
    }

    @Test
    void testSecurityFilterChain() throws Exception {
        HttpSecurity httpSecurity = new HttpSecurity(null, null, null);
        SecurityFilterChain filterChain = securityConfig.securityFilterChain(httpSecurity);
        assertNotNull(filterChain);
    }
}
