package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code DateRangeFlightFilter} реализует интерфейс {@link FlightFilter}
 * и отвечает за фильтрацию полетов по диапазону дат.
 *
 * <p>Фильтр проверяет, чтобы все сегменты полета находились в заданном диапазоне дат,
 * который в данном случае установлен с 1 января 2024 года по 31 декабря 2025 года.
 *
 * <p>Аннотация {@link Override} указывает, что данный класс переопределяет метод фильтрации.
 *
 * @see Flight
 * @see Segment
 * @see FlightFilter
 */
public class DateRangeFlightFilter implements FlightFilter {

    /**
     * Логгер для отслеживания операций фильтрации по диапазону дат.
     * <p>Используется для логирования применения фильтра.
     */
    private static final Logger logger = LoggerFactory.getLogger(DateRangeFlightFilter.class.getName());

    /**
     * Метод фильтрует список полетов, проверяя, чтобы все сегменты каждого полета
     * попадали в указанный диапазон дат.
     *
     * <p>Логирует факт применения фильтра и возвращает только те полеты,
     * которые соответствуют критериям.
     *
     * @param flights список полетов для фильтрации
     * @return отфильтрованный список полетов, попадающих в диапазон дат
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying DateRangeFlightFilter");
        LocalDate minDate = LocalDate.of(2024, 1, 1);
        LocalDate maxDate = LocalDate.of(2025, 12, 31);
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> isInRange(segment, minDate, maxDate)))
                .collect(Collectors.toList());
    }

    /**
     * Проверяет, входит ли дата отправления сегмента в указанный диапазон дат.
     *
     * @param segment сегмент полета для проверки
     * @param minDate минимальная допустимая дата
     * @param maxDate максимальная допустимая дата
     * @return {@code true}, если дата отправления сегмента входит в диапазон,
     *         иначе {@code false}
     */
    private boolean isInRange(Segment segment, LocalDate minDate, LocalDate maxDate) {
        LocalDate departureDate = segment.getDepartureDate().toLocalDate();
        return (departureDate.isEqual(minDate) || departureDate.isAfter(minDate))
                && (departureDate.isEqual(maxDate) || departureDate.isBefore(maxDate));
    }
}
