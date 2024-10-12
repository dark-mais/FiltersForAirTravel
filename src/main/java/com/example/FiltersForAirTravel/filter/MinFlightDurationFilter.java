package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code MinFlightDurationFilter} реализует интерфейс {@link FlightFilter}
 * и фильтрует полеты на основе минимальной продолжительности полета.
 *
 * <p>Фильтр проверяет каждый сегмент полета и исключает те полеты, где
 * продолжительность хотя бы одного сегмента меньше заданного минимального времени.
 *
 * <p>Отмечено использованием аннотации {@link Logger}, чтобы записывать
 * информацию о применении фильтра в лог.
 *
 * @see FlightFilter
 */
public class MinFlightDurationFilter implements FlightFilter {

    /**
     * Логгер для записи информации о работе фильтра.
     */
    private static final Logger logger = LoggerFactory.getLogger(MinFlightDurationFilter.class.getName());

    /**
     * Минимальная продолжительность полета в минутах.
     */
    private final long minDurationInMinutes;

    /**
     * Конструктор создает экземпляр фильтра с заданной минимальной продолжительностью полета.
     *
     * @param minDurationInMinutes минимальная продолжительность полета в минутах
     */
    public MinFlightDurationFilter(long minDurationInMinutes) {
        this.minDurationInMinutes = minDurationInMinutes;
    }

    /**
     * Применяет фильтр к списку полетов, исключая полеты, где хотя бы один сегмент
     * имеет продолжительность меньше минимального времени.
     *
     * <p>Использует стримы для обработки списка полетов и сегментов, с проверкой
     * продолжительности каждого сегмента.
     *
     * @param flights список полетов для фильтрации
     * @return отфильтрованный список полетов, соответствующих минимальной продолжительности
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying MinFlightDurationFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> java.time.Duration.between(segment.getDepartureDate(), segment.getArrivalDate()).toMinutes() >= minDurationInMinutes))
                .collect(Collectors.toList());
    }
}
