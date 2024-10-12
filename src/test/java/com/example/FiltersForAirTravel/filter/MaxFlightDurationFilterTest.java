package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки функциональности фильтра {@link MaxFlightDurationFilter}.
 *
 * <p>Этот класс тестирует фильтрацию полетов на основе максимальной допустимой продолжительности полета.
 */
class MaxFlightDurationFilterTest {

    /**
     * Экземпляр фильтра для тестирования.
     *
     * <p>Фильтрует полеты, продолжительность которых превышает 2 часа (120 минут).
     */
    private MaxFlightDurationFilter filter;

    /**
     * Метод, выполняемый перед каждым тестом для инициализации фильтра.
     *
     * <p>Устанавливает максимальную продолжительность полета в 120 минут.
     */
    @BeforeEach
    void setUp() {
        filter = new MaxFlightDurationFilter(120); // Максимум 2 часа
    }

    /**
     * Тестирует фильтр на двух полетах: один с продолжительностью 180 минут, другой с 90 минутами.
     *
     * <p>Ожидается, что фильтр исключит полет, который длится дольше 120 минут,
     * и оставит только полеты, соответствующие условиям фильтрации.
     */
    @Test
    void testFilter() {
        // Полет с продолжительностью 180 минут
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusMinutes(180))));

        // Полет с продолжительностью 90 минут
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusMinutes(90))));

        // Список полетов для фильтрации
        List<Flight> flights = List.of(flight1, flight2);

        // Применение фильтра
        List<Flight> result = filter.filter(flights);

        // Проверка результатов
        assertEquals(1, result.size());
        assertEquals(flight2, result.get(0));
    }
}
