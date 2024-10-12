package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тест-класс для проверки функциональности фильтра {@link MinFlightDurationFilter}.
 *
 * <p>Тесты предназначены для проверки того, что фильтр корректно исключает
 * полеты с продолжительностью менее минимальной установленной длительности.
 */
class MinFlightDurationFilterTest {

    /**
     * Экземпляр фильтра для проверки минимальной продолжительности полета.
     */
    private MinFlightDurationFilter filter;

    /**
     * Метод инициализации, который выполняется перед каждым тестом.
     *
     * <p>Создает новый экземпляр фильтра с минимальной продолжительностью полета в 60 минут (1 час).
     */
    @BeforeEach
    void setUp() {
        filter = new MinFlightDurationFilter(60); // Min 1 hour
    }

    /**
     * Тест для проверки работы фильтра, который должен исключать полеты
     * с продолжительностью менее 1 часа.
     *
     * <p>Создает два полета: один с продолжительностью 30 минут и другой с продолжительностью 1 час.
     * Проверяется, что фильтр исключает первый полет и оставляет только второй.
     */
    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusMinutes(30))));
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1))));
        List<Flight> flights = List.of(flight1, flight2);

        List<Flight> result = filter.filter(flights);
        assertEquals(1, result.size());
        assertEquals(flight2, result.get(0));
    }
}
