package com.example.FiltersForAirTravel;

import com.example.FiltersForAirTravel.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableAsync
public class FiltersForAirTravel {

    public static void main(String[] args) {
        SpringApplication.run(FiltersForAirTravel.class, args);
    }

    /*@Bean
    @Profile("dev")
    public AppConfig devConfig() {
        return new AppConfig("dev");
    }

    @Bean
    @Profile("prod")
    public AppConfig prodConfig() {
        return new AppConfig("prod");
    }*/
}