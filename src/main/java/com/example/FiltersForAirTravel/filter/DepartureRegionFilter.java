package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code DepartureRegionFilter} реализует интерфейс {@link FlightFilter}
 * и используется для фильтрации полетов по региону отправления.
 *
 * <p>Фильтр проверяет, что все сегменты каждого полета содержат заданный регион
 * в дате отправления сегмента.
 *
 * <p>Класс отмечен аннотацией {@link LoggerFactory}, что позволяет логировать
 * процесс фильтрации.
 *
 * @see FlightFilter
 */
public class DepartureRegionFilter implements FlightFilter {

    /**
     * Логгер для записи информации о выполнении фильтра.
     */
    private static final Logger logger = LoggerFactory.getLogger(DepartureRegionFilter.class.getName());

    /**
     * Регион для фильтрации полетов по дате отправления.
     */
    private final String region;

    /**
     * Конструктор класса {@code DepartureRegionFilter}.
     *
     * @param region регион, который будет использоваться для фильтрации полетов
     */
    public DepartureRegionFilter(String region) {
        this.region = region;
    }

    /**
     * Применяет фильтр по региону отправления к списку полетов.
     *
     * <p>Метод проверяет, что во всех сегментах каждого полета дата отправления
     * содержит указанный регион.
     *
     * @param flights список полетов для фильтрации
     * @return отфильтрованный список полетов, где все сегменты содержат указанный регион
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying DepartureRegionFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().toString().contains(region)))
                .collect(Collectors.toList());
    }
}
