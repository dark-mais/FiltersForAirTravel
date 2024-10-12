package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code MinSegmentsFilter} реализует интерфейс {@link FlightFilter} и
 * используется для фильтрации полетов, которые содержат минимальное количество сегментов.
 *
 * <p>Данный фильтр позволяет исключить полеты, если количество сегментов в полете
 * меньше указанного минимального значения.
 *
 * @see FlightFilter
 */
public class MinSegmentsFilter implements FlightFilter {

    /**
     * Логгер для записи информационных сообщений о применении фильтра.
     */
    private static final Logger logger = LoggerFactory.getLogger(MinSegmentsFilter.class.getName());

    /**
     * Минимальное количество сегментов, необходимое для включения полета в результат.
     */
    private final int minSegments;

    /**
     * Конструктор, инициализирующий минимальное количество сегментов для фильтрации.
     *
     * @param minSegments минимальное количество сегментов в полете
     */
    public MinSegmentsFilter(int minSegments) {
        this.minSegments = minSegments;
    }

    /**
     * Метод для фильтрации списка полетов по минимальному количеству сегментов.
     *
     * <p>Если полет содержит меньше сегментов, чем указано в параметре {@code minSegments},
     * он будет исключен из результата.
     *
     * @param flights список полетов для фильтрации
     * @return отфильтрованный список полетов с количеством сегментов не меньше минимального
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Применяется фильтр MinSegmentsFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().size() >= minSegments)
                .collect(Collectors.toList());
    }
}
