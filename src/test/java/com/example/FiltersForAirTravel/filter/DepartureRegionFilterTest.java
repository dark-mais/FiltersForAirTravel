package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки работы фильтра {@link DepartureRegionFilter}.
 *
 * <p>Этот тест проверяет, что фильтр корректно исключает полеты,
 * не соответствующие заданному региону отправления.
 */
class DepartureRegionFilterTest {

    /**
     * Экземпляр фильтра для проверки полетов по региону отправления.
     */
    private DepartureRegionFilter filter;

    /**
     * Инициализация объекта фильтра перед каждым тестом.
     *
     * <p>Фильтр настраивается на регион "Europe" для последующих проверок.
     */
    @BeforeEach
    void setUp() {
        filter = new DepartureRegionFilter("Europe");
    }

    /**
     * Тест проверяет корректность фильтрации полетов.
     *
     * <p>Создаются два полета с сегментами, указывающими время отправления и прибытия.
     * Предполагается, что проверка по региону осуществляется через метаданные сегмента.
     * В данном тесте ожидается, что результат будет пустым, так как метаданные с регионом
     * еще не реализованы.
     *
     * @throws AssertionError если результат фильтрации не пуст
     */
    @Test
    void testFilter() {
        Flight flight1 = new Flight(List.of(new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(3))));
        Flight flight2 = new Flight(List.of(new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(4))));
        List<Flight> flights = List.of(flight1, flight2);

        // Предполагается, что проверка региона является частью метаданных сегмента
        List<Flight> result = filter.filter(flights);
        // Ожидается пустой результат, так как метаданные с регионом еще не реализованы
        assertTrue(result.isEmpty());
    }
}
