package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс {@code DateRangeFlightFilterTest} предназначен для проверки
 * работы фильтра {@link DateRangeFlightFilter}, который применяет фильтрацию
 * полетов по диапазону дат.
 *
 * <p>Класс проверяет корректность работы метода фильтрации, обеспечивая исключение
 * полетов, которые не попадают в заданный диапазон дат.
 */
class DateRangeFlightFilterTest {

    /**
     * Экземпляр фильтра {@link DateRangeFlightFilter}, используемый для тестирования.
     */
    private DateRangeFlightFilter filter;

    /**
     * Инициализация перед каждым тестом. Создаётся новый экземпляр фильтра {@code DateRangeFlightFilter}.
     */
    @BeforeEach
    void setUp() {
        filter = new DateRangeFlightFilter();
    }

    /**
     * Тест проверяет, что метод фильтрации корректно отбирает полеты,
     * находящиеся в заданном диапазоне дат.
     *
     * <p>Тест использует два полета: один вне диапазона и один в диапазоне.
     * Метод {@code filter} должен исключить первый полет и оставить только второй.
     */
    @Test
    void testFilter() {
        // Создание первого полета с датой вне диапазона
        Flight flight1 = new Flight(List.of(new Segment(
                LocalDateTime.of(2023, 12, 31, 10, 0),
                LocalDateTime.of(2023, 12, 31, 12, 0))));

        // Создание второго полета с датой в диапазоне
        Flight flight2 = new Flight(List.of(new Segment(
                LocalDateTime.of(2024, 6, 15, 10, 0),
                LocalDateTime.of(2024, 6, 15, 12, 0))));

        // Список полетов для фильтрации
        List<Flight> flights = List.of(flight1, flight2);

        // Применение фильтра
        List<Flight> result = filter.filter(flights);

        // Проверка, что фильтр оставил только второй полет
        assertEquals(1, result.size());
        assertEquals(flight2, result.get(0));
    }
}
