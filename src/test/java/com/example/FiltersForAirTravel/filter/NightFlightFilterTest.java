package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки работы фильтра {@link NightFlightFilter},
 * который исключает ночные полеты (с временем вылета в ночное время).
 *
 * <p>Класс использует JUnit для тестирования и включает проверку правильности
 * работы фильтра на основе заданных данных.
 */
class NightFlightFilterTest {

    /**
     * Экземпляр фильтра, который будет использоваться для тестов.
     */
    private NightFlightFilter filter;

    /**
     * Инициализация фильтра перед каждым тестом.
     *
     * <p>Метод отмечен аннотацией {@link BeforeEach}, что означает его
     * автоматический вызов перед выполнением каждого теста.
     */
    @BeforeEach
    void setUp() {
        filter = new NightFlightFilter();
    }

    /**
     * Тест проверяет корректность работы фильтра {@code NightFlightFilter}.
     *
     * <p>Фильтр должен исключить полеты, происходящие в ночное время (в данном случае
     * первый полет), и оставить только те полеты, которые происходят днем (второй полет).
     *
     * <p>Метод отмечен аннотацией {@link Test}, что делает его тестовым методом в JUnit.
     *
     * @throws AssertionError если фильтр возвращает некорректный результат
     */
    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.of(2023, 1, 1, 3, 0), LocalDateTime.of(2023, 1, 1, 5, 0))));
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.of(2023, 1, 1, 8, 0), LocalDateTime.of(2023, 1, 1, 10, 0))));
        List<Flight> flights = List.of(flight1, flight2);

        List<Flight> result = filter.filter(flights);
        assertEquals(1, result.size());
        assertEquals(flight2, result.get(0));
    }
}
