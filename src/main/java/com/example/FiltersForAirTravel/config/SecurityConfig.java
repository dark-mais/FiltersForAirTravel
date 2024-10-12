package com.example.FiltersForAirTravel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Отключение CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").authenticated()  // Новая версия метода
                        .anyRequest().permitAll())
                .httpBasic(withDefaults());
        return http.build();
    }
}
