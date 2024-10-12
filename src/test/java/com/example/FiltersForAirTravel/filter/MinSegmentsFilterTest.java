package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки фильтра {@code MinSegmentsFilter}.
 *
 * <p>Этот класс содержит тесты для фильтрации полетов, которые имеют
 * минимальное количество сегментов. Фильтр исключает полеты, у которых
 * количество сегментов меньше указанного минимального значения.
 */
class MinSegmentsFilterTest {

    /**
     * Фильтр для минимального количества сегментов.
     */
    private MinSegmentsFilter filter;

    /**
     * Настраивает начальное состояние перед каждым тестом.
     *
     * <p>Создает экземпляр {@code MinSegmentsFilter} с минимальным количеством сегментов равным 2.
     */
    @BeforeEach
    void setUp() {
        filter = new MinSegmentsFilter(2); // Min 2 segments
    }

    /**
     * Тестирует, что фильтр корректно отфильтровывает полеты с недостаточным количеством сегментов.
     *
     * <p>Создает два полета: один с одним сегментом и один с двумя сегментами.
     * Проверяет, что фильтр исключает полет с одним сегментом и оставляет только полет с двумя сегментами.
     */
    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1))));
        Flight flight2 = new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
                new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3))
        ));
        List<Flight> flights = List.of(flight1, flight2);

        List<Flight> result = filter.filter(flights);
        assertEquals(1, result.size());
        assertEquals(flight2, result.get(0));
    }
}
