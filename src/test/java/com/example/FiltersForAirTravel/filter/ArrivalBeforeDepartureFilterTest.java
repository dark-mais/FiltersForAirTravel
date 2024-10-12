package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки работы фильтра {@link ArrivalBeforeDepartureFilter}.
 *
 * <p>Фильтр удаляет полеты, у которых время прибытия раньше времени вылета.
 */
class ArrivalBeforeDepartureFilterTest {

    /**
     * Экземпляр фильтра для тестирования.
     */
    private ArrivalBeforeDepartureFilter filter;

    /**
     * Метод, который инициализирует объект фильтра перед каждым тестом.
     *
     * <p>Аннотация {@link BeforeEach} указывает, что этот метод будет вызываться перед запуском каждого теста.
     */
    @BeforeEach
    void setUp() {
        filter = new ArrivalBeforeDepartureFilter();
    }

    /**
     * Тестирует работу фильтра {@link ArrivalBeforeDepartureFilter}.
     *
     * <p>Создаются два полета: один с сегментом, у которого время прибытия раньше времени вылета,
     * и второй с корректным временем. Ожидается, что фильтр исключит первый полет.
     */
    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().minusHours(1))));
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1))));
        List<Flight> flights = List.of(flight1, flight2);

        List<Flight> result = filter.filter(flights);

        // Проверяем, что фильтр вернул только один полет
        assertEquals(1, result.size());
        // Проверяем, что вернулся корректный полет
        assertEquals(flight2, result.get(0));
    }
}
