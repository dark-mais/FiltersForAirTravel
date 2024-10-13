package com.example.FiltersForAirTravel.config;

import com.example.FiltersForAirTravel.filter.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Конфигурационный класс приложения для создания и настройки фильтров полетов.
 *
 * <p>Этот класс используется для конфигурирования компонентов, связанных с фильтрацией
 * данных о полетах. Основной компонент {@code CompositeFlightFilter} включает
 * несколько отдельных фильтров, которые применяются последовательно.
 *
 * <p>Отмечен аннотацией {@link Configuration}, что указывает на то, что этот класс
 * содержит методы для создания бинов Spring.G
 *
 * @see CompositeFlightFilter
 * @see FlightFilter
 */
@Configuration
public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    /**
     * Создает и настраивает объект {@code CompositeFlightFilter}, который содержит
     * список фильтров для полетов.
     *
     * <p>Метод собирает все фильтры, конфигурированные в {@link #configureFilters()},
     * и добавляет их в объект {@code CompositeFlightFilter}, который затем используется
     * для фильтрации полетов по множественным критериям.
     *
     * @return сконфигурированный {@link CompositeFlightFilter}, содержащий все необходимые фильтры
     */
    @Bean
    public CompositeFlightFilter compositeFlightFilter() {
        CompositeFlightFilter compositeFilter = new CompositeFlightFilter();
        List<FlightFilter> filters = configureFilters();
        filters.forEach(compositeFilter::addFilter);
        return compositeFilter;
    }

    /**
     * Конфигурирует список фильтров для полетов.
     *
     * <p>Метод создает и возвращает список объектов, реализующих интерфейс {@link FlightFilter}.
     * Каждый фильтр отвечает за проверку определенного условия, например, времени отправления
     * или количества пересадок. Эти фильтры затем используются в составе {@code CompositeFlightFilter}.
     *
     * <p>Примеры фильтров включают:
     * <ul>
     *   <li>{@code DepartureBeforeNowFilter} — исключает полеты, которые начинаются до текущего времени;</li>
     *   <li>{@code ArrivalBeforeDepartureFilter} — исключает полеты, где время прибытия раньше времени отправления;</li>
     *   <li>{@code GroundTimeExceedsTwoHoursFilter} — исключает полеты с временем пересадки на земле более 2 часов;</li>
     *   <li>{@code MaxStopsFilter} — ограничивает максимальное количество пересадок (например, до 1 пересадки);</li>
     *   <li>{@code MinFlightDurationFilter} — задает минимальную продолжительность полета (например, 30 минут);</li>
     *   <li>{@code MaxFlightDurationFilter} — ограничивает максимальную продолжительность полета (например, 10 часов);</li>
     *   <li>{@code MinSegmentsFilter} — определяет минимальное количество сегментов (например, минимум 2 сегмента);</li>
     *   <li>{@code MaxSegmentsFilter} — ограничивает максимальное количество сегментов (например, до 5 сегментов);</li>
     *   <li>{@code NightFlightFilter} — исключает ночные рейсы (например, с 22:00 до 06:00);</li>
     *   <li>{@code WeekendFlightFilter} — исключает рейсы, вылетающие в выходные (суббота и воскресенье);</li>
     *   <li>{@code DateRangeFlightFilter} — фильтрует рейсы по диапазону дат (например, с определенной даты по другую);</li>
     *   <li>{@code DepartureRegionFilter} — фильтрует рейсы по региону отправления (например, только рейсы из Европы);</li>
     *   <li>{@code ArrivalRegionFilter} — фильтрует рейсы по региону прибытия (например, только рейсы в Азию);</li>
     *   <li>{@code StopDurationFilter} — ограничивает максимальную длительность пересадок (например, до 3 часов);</li>
     *   <li>{@code GroundTimeLimitFilter} — задает общий лимит времени нахождения на земле между сегментами (например, 120 минут);</li>
     *   <li>{@code DaytimeFlightFilter} — включает только рейсы, вылетающие в дневное время (например, с 08:00 до 20:00);</li>
     *   <li>{@code NonStopFlightFilter} — фильтрует рейсы без пересадок (прямые рейсы);</li>
     *   <li>{@code AirlineFilter} — фильтрует рейсы по авиакомпаниям (например, только рейсы определенных авиакомпаний);</li>
     *   <li>{@code AircraftTypeFilter} — фильтрует рейсы по типу самолета (например, только рейсы на определенном типе самолета);</li>
     *   <li>{@code LayoverLocationFilter} — фильтрует рейсы по местоположению пересадки (например, исключает пересадки в определенных аэропортах);</li>
     * </ul>
     *
     * @return список объектов {@link FlightFilter}, готовых к использованию для фильтрации полетов
     */
    @Bean
    public List<FlightFilter> configureFilters() {
        List<FlightFilter> filters = new ArrayList<>();
        filters.add(new DepartureBeforeNowFilter());
        filters.add(new ArrivalBeforeDepartureFilter());
        filters.add(new GroundTimeExceedsTwoHoursFilter());
        filters.add(new MaxStopsFilter(1));
        filters.add(new MinFlightDurationFilter(30));
        filters.add(new MaxFlightDurationFilter(10 * 60));
        filters.add(new MinSegmentsFilter(2));
        filters.add(new MaxSegmentsFilter(5));
        filters.add(new NightFlightFilter());
        filters.add(new WeekendFlightFilter());
        filters.add(new DateRangeFlightFilter());
        filters.add(new DepartureRegionFilter("Europe"));
        filters.add(new ArrivalRegionFilter("Asia"));
        filters.add(new StopDurationFilter(3 * 60));
        filters.add(new GroundTimeLimitFilter(120));
        return filters;
    }
}
