package com.example.FiltersForAirTravel.config;

import com.example.FiltersForAirTravel.filter.FlightFilter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки конфигураций фильтров полетов в различных профилях.
 *
 * <p>Тесты проверяют корректность конфигурации фильтров для профилей "dev" и "prod".
 *
 * <p>Класс использует JUnit для выполнения тестов, проверяя, что конфигурации содержат
 * правильное количество фильтров и что они успешно создаются.
 */
public class AppConfigTest {

    /**
     * Конфигурация для профиля "dev".
     *
     * <p>Будет проверена корректность создания фильтров для среды разработки.
     */
    private AppConfig devConfig;

    /**
     * Конфигурация для профиля "prod".
     *
     * <p>Будет проверена корректность создания фильтров для боевой среды.
     */
    private AppConfig prodConfig;

    /**
     * Тест проверяет, что конфигурация фильтров для профиля "dev" корректна.
     *
     * <p>Проверяется, что фильтры создаются, они не пусты, и их количество равно 15.
     *
     * @throws AssertionError если список фильтров пуст или количество фильтров не равно 15
     */
    @Test
    void testDevConfig() {
        List<FlightFilter> filters = devConfig.configureFilters();
        assertNotNull(filters);
        assertFalse(filters.isEmpty());
        assertEquals(15, filters.size(), "Количество фильтров должно быть равно 15 в конфигурации dev");
    }

    /**
     * Тест проверяет, что конфигурация фильтров для профиля "prod" корректна.
     *
     * <p>Проверяется, что фильтры создаются, они не пусты, и их количество равно 15.
     *
     * @throws AssertionError если список фильтров пуст или количество фильтров не равно 15
     */
    @Test
    void testProdConfig() {
        List<FlightFilter> filters = prodConfig.configureFilters();
        assertNotNull(filters);
        assertFalse(filters.isEmpty());
        assertEquals(15, filters.size(), "Количество фильтров должно быть равно 15 в конфигурации prod");
    }
}
