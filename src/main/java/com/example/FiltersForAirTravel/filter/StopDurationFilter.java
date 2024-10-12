package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code StopDurationFilter} реализует интерфейс {@link FlightFilter}
 * и предоставляет логику для фильтрации полетов на основе максимальной длительности остановок.
 *
 * <p>Фильтр исключает полеты, у которых суммарное время стоянок превышает
 * заданное количество минут {@code maxStopDurationInMinutes}.
 *
 * <p>Этот класс использует {@link Logger} для ведения логов выполнения фильтрации.
 */
public class StopDurationFilter implements FlightFilter {

    /**
     * Логгер для записи информации о процессе фильтрации.
     */
    private static final Logger logger = LoggerFactory.getLogger(StopDurationFilter.class.getName());

    /**
     * Максимальная допустимая продолжительность остановки в минутах.
     */
    private final long maxStopDurationInMinutes;

    /**
     * Конструктор создает экземпляр фильтра с заданной максимальной продолжительностью остановки.
     *
     * @param maxStopDurationInMinutes максимальная продолжительность остановки в минутах
     */
    public StopDurationFilter(long maxStopDurationInMinutes) {
        this.maxStopDurationInMinutes = maxStopDurationInMinutes;
    }

    /**
     * Метод фильтрует список полетов, исключая те, у которых суммарное время остановок превышает
     * заданное значение {@code maxStopDurationInMinutes}.
     *
     * <p>Логгирует процесс применения фильтра с помощью логгера.
     *
     * @param flights список полетов, который нужно отфильтровать
     * @return отфильтрованный список полетов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying StopDurationFilter");
        return flights.stream()
                .filter(flight -> calculateTotalStopDuration(flight) <= maxStopDurationInMinutes)
                .collect(Collectors.toList());
    }

    /**
     * Метод вычисляет суммарное время остановок между сегментами полета.
     *
     * @param flight полет, для которого нужно вычислить время остановок
     * @return суммарная продолжительность остановок в минутах
     */
    private long calculateTotalStopDuration(Flight flight) {
        long totalStopDuration = 0;
        List<Segment> segments = flight.getSegments();
        for (int i = 1; i < segments.size(); i++) {
            Segment previousSegment = segments.get(i - 1);
            Segment currentSegment = segments.get(i);
            totalStopDuration += java.time.Duration.between(previousSegment.getArrivalDate(), currentSegment.getDepartureDate()).toMinutes();
        }
        return totalStopDuration;
    }
}
