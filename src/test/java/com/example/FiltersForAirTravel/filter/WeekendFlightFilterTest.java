package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки фильтра {@link WeekendFlightFilter}.
 *
 * <p>Данный класс проверяет работу фильтра, который исключает полеты,
 * происходящие в выходные дни (суббота и воскресенье).
 */
class WeekendFlightFilterTest {

    /**
     * Экземпляр фильтра для тестирования, который исключает полеты в выходные.
     */
    private WeekendFlightFilter filter;

    /**
     * Инициализация объекта фильтра перед каждым тестом.
     *
     * <p>Аннотация {@link BeforeEach} гарантирует, что этот метод будет выполняться перед каждым
     * тестовым методом для установки исходного состояния.
     */
    @BeforeEach
    void setUp() {
        filter = new WeekendFlightFilter();
    }

    /**
     * Тест проверяет корректность работы метода {@link WeekendFlightFilter#filter(List)}.
     *
     * <p>В тесте создается два полета: один на субботу и один на пятницу.
     * Ожидается, что фильтр исключит субботний полет и оставит только пятничный.
     *
     * <p>Используются аннотации:
     * <ul>
     *     <li>{@link Test} — указывает, что метод является тестовым</li>
     * </ul>
     */
    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.of(2023, 1, 7, 10, 0), LocalDateTime.of(2023, 1, 7, 12, 0)))); // суббота
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.of(2023, 1, 6, 10, 0), LocalDateTime.of(2023, 1, 6, 12, 0)))); // пятница
        List<Flight> flights = List.of(flight1, flight2);

        List<Flight> result = filter.filter(flights);
        assertEquals(1, result.size());
        assertEquals(flight2, result.get(0));
    }
}
