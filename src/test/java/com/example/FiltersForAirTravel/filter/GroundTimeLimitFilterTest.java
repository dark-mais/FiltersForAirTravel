package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки фильтра {@link GroundTimeLimitFilter}, который исключает
 * полеты, где общее время на земле между сегментами превышает заданное значение.
 *
 * <p>Этот класс использует аннотацию {@link BeforeEach} для инициализации фильтра
 * перед каждым тестом и {@link Test} для тестирования логики фильтрации.
 */
class GroundTimeLimitFilterTest {

    /**
     * Объект фильтра, который проверяет общее время на земле между сегментами полета.
     */
    private GroundTimeLimitFilter filter;

    /**
     * Метод, выполняющийся перед каждым тестом, для инициализации фильтра с ограничением
     * на максимальное время на земле в 120 минут.
     */
    @BeforeEach
    void setUp() {
        filter = new GroundTimeLimitFilter(120); // Max 120 minutes ground time
    }

    /**
     * Тест проверяет правильность фильтрации полетов.
     *
     * <p>Создаются два полета:
     * <ul>
     *   <li>Первый полет содержит сегменты с перерывом на земле, превышающим 120 минут.</li>
     *   <li>Второй полет содержит сегменты с перерывом на земле, который меньше 120 минут.</li>
     * </ul>
     * Ожидается, что фильтр исключит первый полет и вернет только второй полет.
     */
    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
                new Segment(LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(6))
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
