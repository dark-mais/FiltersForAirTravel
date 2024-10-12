package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс {@code MaxSegmentsFilterTest} для проверки фильтрации полетов
 * по максимальному количеству сегментов.
 *
 * <p>Данный класс содержит тесты для проверки работы фильтра {@link MaxSegmentsFilter},
 * который ограничивает количество сегментов в каждом полете.
 */
class MaxSegmentsFilterTest {

    /**
     * Экземпляр фильтра для проверки полетов.
     */
    private MaxSegmentsFilter filter;

    /**
     * Метод инициализации перед каждым тестом.
     *
     * <p>Создает экземпляр фильтра {@code MaxSegmentsFilter}, который
     * ограничивает максимальное количество сегментов до трех.
     */
    @BeforeEach
    void setUp() {
        filter = new MaxSegmentsFilter(3); // Максимум 3 сегмента
    }

    /**
     * Тест проверяет корректность работы фильтра {@code MaxSegmentsFilter}.
     *
     * <p>Тестирует сценарий, при котором список полетов включает два полета:
     * один с четырьмя сегментами и один с двумя сегментами. Фильтр должен
     * исключить полет с четырьмя сегментами и оставить только полет с двумя сегментами.
     *
     * <p>Ожидается, что результатом фильтрации будет список, содержащий один полет.
     */
    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
                new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3)),
                new Segment(LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(5)),
                new Segment(LocalDateTime.now().plusHours(6), LocalDateTime.now().plusHours(7))
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
