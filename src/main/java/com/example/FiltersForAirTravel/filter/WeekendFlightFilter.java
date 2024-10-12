package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code WeekendFlightFilter} предназначен для фильтрации полетов, которые
 * происходят в выходные дни (суббота или воскресенье).
 *
 * <p>Реализует интерфейс {@link FlightFilter}, предоставляя логику для исключения полетов,
 * у которых все сегменты происходят в выходные дни.
 *
 * <p>Аннотация {@link Override} указывает на реализацию метода из интерфейса {@code FlightFilter}.
 *
 * @see FlightFilter
 * @see Segment
 */
public class WeekendFlightFilter implements FlightFilter {

    /**
     * Логгер для регистрации информации о процессе фильтрации полетов.
     *
     * <p>Использует {@link LoggerFactory} для создания логгера, привязанного к имени класса.
     */
    private static final Logger logger = LoggerFactory.getLogger(WeekendFlightFilter.class.getName());

    /**
     * Применяет фильтр для исключения полетов, которые происходят в выходные дни.
     *
     * <p>Метод проверяет каждый сегмент полета, и если хотя бы один сегмент происходит
     * в выходной день (суббота или воскресенье), то данный полет исключается.
     *
     * @param flights список полетов для фильтрации
     * @return список полетов, которые не содержат сегментов в выходные дни
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying WeekendFlightFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> !isWeekendFlight(segment)))
                .collect(Collectors.toList());
    }

    /**
     * Проверяет, происходит ли сегмент полета в выходной день (суббота или воскресенье).
     *
     * @param segment сегмент полета для проверки
     * @return {@code true}, если сегмент происходит в выходной день, иначе {@code false}
     */
    private boolean isWeekendFlight(Segment segment) {
        int dayOfWeek = segment.getDepartureDate().getDayOfWeek().getValue();
        return dayOfWeek == 6 || dayOfWeek == 7; // Суббота или Воскресенье
    }
}
