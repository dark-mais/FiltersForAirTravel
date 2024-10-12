package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс {@code GroundTimeExceedsTwoHoursFilterTest} проверяет корректность работы фильтра,
 * исключающего полеты, где время на земле превышает два часа.
 *
 * <p>Тесты в этом классе проверяют, что фильтр правильно обрабатывает списки полетов
 * и исключает те, где продолжительность ожидания между сегментами превышает заданный лимит.
 *
 * @see GroundTimeExceedsTwoHoursFilter
 */
class GroundTimeExceedsTwoHoursFilterTest {

    /**
     * Экземпляр фильтра для тестирования.
     *
     * <p>Инициализируется перед каждым тестом.
     */
    private GroundTimeExceedsTwoHoursFilter filter;

    /**
     * Метод, выполняемый перед каждым тестом, инициализирующий новый экземпляр фильтра.
     */
    @BeforeEach
    void setUp() {
        filter = new GroundTimeExceedsTwoHoursFilter();
    }

    /**
     * Тест проверяет, что фильтр корректно исключает полеты с превышением времени на земле
     * более двух часов.
     *
     * <p>В этом тесте создаются два полета: один с превышением времени ожидания на земле,
     * другой — без превышения. Ожидается, что фильтр вернет только второй полет.
     */
    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
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
