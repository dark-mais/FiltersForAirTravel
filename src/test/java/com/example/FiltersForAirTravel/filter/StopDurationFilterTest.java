package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки фильтра {@link StopDurationFilter}, который
 * исключает полеты, если продолжительность пересадки превышает указанное время.
 *
 * <p>Тесты включают проверку фильтрации полетов с различными продолжительностями
 * пересадок, чтобы убедиться, что фильтр работает корректно.
 */
class StopDurationFilterTest {

    /** Фильтр для ограничения максимальной продолжительности пересадок. */
    private StopDurationFilter filter;

    /**
     * Инициализация перед каждым тестом.
     *
     * <p>Создает новый экземпляр фильтра {@link StopDurationFilter} с максимальной
     * допустимой продолжительностью пересадки в 180 минут (3 часа).
     */
    @BeforeEach
    void setUp() {
        filter = new StopDurationFilter(180); // Максимальная продолжительность пересадки 3 часа
    }

    /**
     * Тест для проверки фильтрации полетов с различной продолжительностью пересадок.
     *
     * <p>Тестирует два полета: один с пересадкой более 3 часов, и один с пересадкой менее
     * 3 часов. Ожидается, что фильтр исключит первый полет, а второй полет останется.
     */
    @Test
    void testFilter() {
        // Создаем полет с пересадкой более 3 часов
        Flight flight1 = new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
                new Segment(LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(6))
        ));

        // Создаем полет с пересадкой менее 3 часов
        Flight flight2 = new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
                new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4))
        ));

        List<Flight> flights = List.of(flight1, flight2);

        // Применяем фильтр и проверяем результат
        List<Flight> result = filter.filter(flights);
        assertEquals(1, result.size());
        assertEquals(flight2, result.get(0)); // Ожидается, что останется только flight2
    }
}
