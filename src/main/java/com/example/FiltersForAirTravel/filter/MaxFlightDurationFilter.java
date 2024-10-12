package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code MaxFlightDurationFilter} реализует интерфейс {@link FlightFilter} и
 * предназначен для фильтрации полетов на основе максимальной продолжительности полета.
 *
 * <p>Фильтр исключает полеты, у которых длительность одного из сегментов превышает
 * установленное максимальное значение {@code maxDurationInMinutes}.
 *
 * <p>Отмечен использованием логгера {@link Logger}, чтобы отслеживать процесс фильтрации.
 */
public class MaxFlightDurationFilter implements FlightFilter {

    /**
     * Логгер для отслеживания выполнения фильтра {@code MaxFlightDurationFilter}.
     */
    private static final Logger logger = LoggerFactory.getLogger(MaxFlightDurationFilter.class.getName());

    /**
     * Максимальная продолжительность полета в минутах, используемая для фильтрации.
     */
    private final long maxDurationInMinutes;

    /**
     * Конструктор класса {@code MaxFlightDurationFilter}, инициализирующий максимальную продолжительность полета.
     *
     * @param maxDurationInMinutes максимальная длительность полета в минутах
     */
    public MaxFlightDurationFilter(long maxDurationInMinutes) {
        this.maxDurationInMinutes = maxDurationInMinutes;
    }

    /**
     * Метод фильтрации списка полетов по максимальной длительности сегментов.
     *
     * <p>Логгирует применение фильтра и возвращает список полетов, где каждый сегмент имеет продолжительность
     * меньше или равную значению {@code maxDurationInMinutes}.
     *
     * @param flights список полетов для фильтрации
     * @return отфильтрованный список полетов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying MaxFlightDurationFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> java.time.Duration.between(segment.getDepartureDate(), segment.getArrivalDate()).toMinutes() <= maxDurationInMinutes))
                .collect(Collectors.toList());
    }
}
