package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code DepartureBeforeNowFilter} реализует фильтр, который исключает полеты,
 * где время отправления сегментов меньше текущего времени.
 *
 * <p>Данный фильтр применяется ко всем сегментам полета. Если хотя бы один сегмент
 * имеет время отправления раньше текущего момента, полет будет исключен из списка.
 *
 * <p>Класс аннотирован для ведения логов с использованием {@link Logger} и {@link LoggerFactory}.
 *
 * @see FlightFilter
 */
public class DepartureBeforeNowFilter implements FlightFilter {

    /**
     * Логгер для записи информации о процессе фильтрации.
     */
    private static final Logger logger = LoggerFactory.getLogger(DepartureBeforeNowFilter.class.getName());

    /**
     * Применяет фильтр, исключающий полеты с отправлением до текущего момента времени.
     *
     * <p>Метод фильтрует список полетов, исключая те, которые содержат сегменты с временем
     * отправления до текущего времени.
     *
     * @param flights список полетов для фильтрации
     * @return отфильтрованный список полетов, где все сегменты имеют время отправления
     *         после текущего момента
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        logger.info("Applying DepartureBeforeNowFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(now)))
                .collect(Collectors.toList());
    }
}
