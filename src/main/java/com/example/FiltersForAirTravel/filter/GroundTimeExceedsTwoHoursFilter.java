package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Фильтр {@code GroundTimeExceedsTwoHoursFilter} реализует интерфейс {@link FlightFilter}
 * и предназначен для исключения полетов, где общее время на земле между сегментами превышает два часа.
 *
 * <p>Этот класс используется для фильтрации полетов по критерию общего времени ожидания на земле
 * между сегментами рейсов. Если время ожидания превышает два часа, такой полет исключается из списка.
 *
 * <p>Логирование осуществляется с помощью {@link Logger}, чтобы отслеживать применение фильтра.
 *
 * @see FlightFilter
 * @see Flight
 * @see Segment
 */
public class GroundTimeExceedsTwoHoursFilter implements FlightFilter {

    /**
     * Логгер для отслеживания применения фильтра.
     */
    private static final Logger logger = LoggerFactory.getLogger(GroundTimeExceedsTwoHoursFilter.class.getName());

    /**
     * Применяет фильтр ко списку полетов, исключая те, у которых общее время на земле
     * между сегментами превышает два часа.
     *
     * @param flights список полетов для фильтрации
     * @return отфильтрованный список полетов, у которых общее время ожидания на земле не превышает два часа
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying GroundTimeExceedsTwoHoursFilter");
        return flights.stream()
                .filter(flight -> calculateTotalGroundTime(flight) <= 120)
                .collect(Collectors.toList());
    }

    /**
     * Рассчитывает общее время ожидания на земле между сегментами полета.
     *
     * @param flight полет, для которого рассчитывается общее время ожидания на земле
     * @return общее время ожидания на земле в минутах
     */
    private long calculateTotalGroundTime(Flight flight) {
        long totalGroundTime = 0;
        List<Segment> segments = flight.getSegments();
        for (int i = 1; i < segments.size(); i++) {
            Segment previousSegment = segments.get(i - 1);
            Segment currentSegment = segments.get(i);
            totalGroundTime += java.time.Duration.between(previousSegment.getArrivalDate(), currentSegment.getDepartureDate()).toMinutes();
        }
        return totalGroundTime;
    }
}
