package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки работы фильтра {@link MaxStopsFilter}.
 *
 * <p>Этот тест проверяет, что фильтр корректно исключает полеты,
 * которые содержат больше пересадок, чем указано в максимальном лимите.
 */
public class MaxStopsFilterTest {

    /**
     * Фильтр для проверки максимального количества пересадок.
     * В данном тесте используется значение {@code 1}, что означает, что
     * полеты с более чем одной пересадкой будут исключены.
     */
    private MaxStopsFilter filter;

    /**
     * Метод, который выполняется перед каждым тестом и подготавливает
     * экземпляр фильтра {@code MaxStopsFilter} с максимальным числом пересадок в 1.
     */
    @BeforeEach
    void setUp() {
        filter = new MaxStopsFilter(1); // Max 1 stop
    }

    /**
     * Тест проверяет, что фильтр корректно исключает полеты, имеющие
     * более одной пересадки.
     *
     * <p>В данном тесте создаются два полета:
     * <ul>
     *   <li>Первый полет содержит три сегмента (две пересадки)</li>
     *   <li>Второй полет содержит два сегмента (одна пересадка)</li>
     * </ul>
     * После применения фильтра в результате должен остаться только второй полет.
     *
     * @throws AssertionError если результат фильтрации не соответствует ожидаемому
     */
    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
                new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3)),
                new Segment(LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(5))
        ));
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
