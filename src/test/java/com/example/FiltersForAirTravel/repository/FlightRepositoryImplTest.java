package com.example.FiltersForAirTravel.repository;

import com.example.FiltersForAirTravel.entity.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс {@code FlightRepositoryImplTest} содержит тесты для проверки
 * реализации репозитория {@link FlightRepositoryImpl}.
 *
 * <p>Тесты проверяют корректность работы методов репозитория,
 * таких как получение всех полетов.
 *
 * <p>Отмечен аннотацией {@link Repository}, указывающей на его роль
 * как класса для тестирования репозитория данных.
 */
@Repository
class FlightRepositoryImplTest {

    /**
     * Экземпляр класса репозитория для тестирования.
     */
    private FlightRepositoryImpl flightRepository;

    /**
     * Метод, который инициализирует объект {@code FlightRepositoryImpl} перед каждым тестом.
     *
     * <p>Этот метод вызывается перед каждым тестом с помощью аннотации {@link BeforeEach}.
     */
    @BeforeEach
    void setUp() {
        flightRepository = new FlightRepositoryImpl();
    }

    /**
     * Тест проверяет, что метод {@code getAllFlights()} возвращает
     * не пустой список полетов.
     */
    @Test
    void testGetAllFlights() {
        List<Flight> flights = flightRepository.getAllFlights();
        assertNotNull(flights);
        assertFalse(flights.isEmpty());
    }
}
