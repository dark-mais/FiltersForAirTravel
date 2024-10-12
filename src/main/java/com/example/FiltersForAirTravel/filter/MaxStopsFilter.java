package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code MaxStopsFilter} применяется для фильтрации полетов по количеству
 * остановок (пересадок).
 *
 * <p>Фильтр отбирает полеты, у которых количество сегментов не превышает
 * допустимое число, заданное в параметре {@code maxStops}.
 *
 * <p>Отмечен как {@link FlightFilter}, что означает его использование для применения
 * конкретного фильтра к списку полетов.
 */
public class MaxStopsFilter implements FlightFilter {

    /**
     * Логгер для записи информации о работе фильтра.
     *
     * <p>Используется для логирования при применении фильтрации.
     */
    private static final Logger logger = LoggerFactory.getLogger(MaxStopsFilter.class.getName());

    /**
     * Максимально допустимое количество остановок (пересадок) в полете.
     */
    private final int maxStops;

    /**
     * Конструктор, принимающий максимальное количество остановок для фильтрации.
     *
     * @param maxStops максимальное число остановок (пересадок), допустимых для полетов
     */
    public MaxStopsFilter(int maxStops) {
        this.maxStops = maxStops;
    }

    /**
     * Применяет фильтр для исключения полетов, у которых количество сегментов больше
     * допустимого значения.
     *
     * <p>Метод фильтрует список полетов и оставляет только те, у которых количество сегментов
     * не превышает {@code maxStops} + 1 (один сегмент всегда подразумевает прямой перелет).
     *
     * @param flights список полетов для фильтрации
     * @return отфильтрованный список полетов, у которых допустимое количество пересадок
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Применение MaxStopsFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().size() <= maxStops + 1)
                .collect(Collectors.toList());
    }
}
