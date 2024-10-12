package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code ArrivalBeforeDepartureFilter} отвечает за фильтрацию полетов,
 * в которых сегменты имеют корректные даты прибытия и отправления.
 *
 * <p>Полеты, у которых время прибытия в любом сегменте происходит до времени отправления,
 * исключаются. Класс реализует интерфейс {@link FlightFilter}.
 *
 * <p>Аннотация {@link Override} используется для указания того, что метод
 * {@code filter} переопределяет метод интерфейса {@code FlightFilter}.
 *
 * @see FlightFilter
 */
public class ArrivalBeforeDepartureFilter implements FlightFilter {

    /**
     * Логгер для регистрации действий фильтрации.
     *
     * <p>Используется для логгирования информации о процессе применения фильтра
     * в классе {@code ArrivalBeforeDepartureFilter}.
     */
    private static final Logger logger = LoggerFactory.getLogger(ArrivalBeforeDepartureFilter.class.getName());

    /**
     * Фильтрует список полетов, исключая те, у которых время прибытия
     * в сегменте раньше времени отправления.
     *
     * <p>Логирует начало процесса фильтрации и возвращает отфильтрованный список.
     *
     * @param flights список полетов, подлежащих фильтрации
     * @return список полетов, у которых все сегменты имеют корректные времена
     *         прибытия и отправления
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying ArrivalBeforeDepartureFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}

