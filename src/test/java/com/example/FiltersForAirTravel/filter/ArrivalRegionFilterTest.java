package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс {@code ArrivalRegionFilterTest} проверяет корректность работы фильтра
 * {@link ArrivalRegionFilter}, который отфильтровывает полеты по региону прибытия.
 *
 * <p>Фильтр проверяет полеты на соответствие указанному региону прибытия. В тестах используется
 * регион "Asia" для проверки фильтрации.
 *
 * @see ArrivalRegionFilter
 */
class ArrivalRegionFilterTest {

    /**
     * Фильтр для проверки региона прибытия.
     *
     * <p>Инициализируется в методе {@link #setUp()} с регионом "Asia".
     */
    private ArrivalRegionFilter filter;

    /**
     * Устанавливает начальное состояние перед каждым тестом.
     *
     * <p>Метод инициализирует фильтр с регионом "Asia", который будет использоваться в тестах.
     */
    @BeforeEach
    void setUp() {
        filter = new ArrivalRegionFilter("Asia");
    }

    /**
     * Тест проверяет, что фильтр возвращает пустой список полетов, так как метаданные
     * с информацией о регионе прибытия еще не реализованы.
     *
     * <p>Создаются два полета с разными временными сегментами, затем применяется фильтр по
     * региону. Ожидается, что результатом будет пустой список.
     */
    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3))));
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(4))));
        List<Flight> flights = List.of(flight1, flight2);

        // Предполагаем, что проверка региона выполняется в метаданных сегмента (пока не реализовано)
        List<Flight> result = filter.filter(flights);

        // Тест должен завершиться неудачей, так как метаданные региона не реализованы
        assertTrue(result.isEmpty());
    }
}
