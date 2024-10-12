package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки работы фильтра {@link DepartureBeforeNowFilter}.
 *
 * <p>Фильтр исключает полеты с временем отправления, которое меньше текущего времени.
 * Данный класс проверяет корректность работы фильтра с использованием реальных данных
 * полетов.
 *
 * @see DepartureBeforeNowFilter
 */
class DepartureBeforeNowFilterTest {

    /**
     * Экземпляр фильтра для проверки полетов.
     */
    private DepartureBeforeNowFilter filter;

    /**
     * Метод выполняется перед каждым тестом и инициализирует экземпляр фильтра.
     */
    @BeforeEach
    void setUp() {
        filter = new DepartureBeforeNowFilter();
    }

    /**
     * Тест проверяет работу фильтра {@link DepartureBeforeNowFilter}.
     *
     * <p>Создаются два полета: один с отправлением в прошлом и один в будущем.
     * Фильтр должен оставить только полет с отправлением в будущем.
     *
     * <p>Проверяется, что размер отфильтрованного списка равен 1, и что в списке
     * остается только полет с будущим временем отправления.
     */
    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(2))));
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2))));
        List<Flight> flights = List.of(flight1, flight2);

        List<Flight> result = filter.filter(flights);
        assertEquals(1, result.size());
        assertEquals(flight2, result.get(0));
    }
}
