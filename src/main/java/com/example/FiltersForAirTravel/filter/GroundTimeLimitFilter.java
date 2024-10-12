package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code GroundTimeLimitFilter} реализует фильтр для проверки максимального
 * времени нахождения на земле между сегментами полета.
 *
 * <p>Данный фильтр исключает полеты, в которых общее время на земле между сегментами
 * превышает заданное максимальное количество минут.
 *
 * <p>Класс отмечен интерфейсом {@link FlightFilter}, что указывает на его использование
 * для фильтрации списка полетов.
 *
 * @see Flight
 * @see Segment
 */
public class GroundTimeLimitFilter implements FlightFilter {

    /**
     * Логгер для отслеживания операций фильтрации.
     */
    private static final Logger logger = LoggerFactory.getLogger(GroundTimeLimitFilter.class.getName());

    /**
     * Максимальное допустимое время нахождения на земле между сегментами полета (в минутах).
     */
    private final long maxGroundTimeInMinutes;

    /**
     * Конструктор для создания фильтра {@code GroundTimeLimitFilter}.
     *
     * @param maxGroundTimeInMinutes максимальное время нахождения на земле в минутах
     */
    public GroundTimeLimitFilter(long maxGroundTimeInMinutes) {
        this.maxGroundTimeInMinutes = maxGroundTimeInMinutes;
    }

    /**
     * Метод для фильтрации списка полетов, где общее время нахождения на земле между
     * сегментами не превышает заданное значение.
     *
     * <p>Фильтрация производится путем расчета общего времени между прилетом одного сегмента
     * и вылетом следующего сегмента.
     *
     * @param flights список полетов для фильтрации
     * @return отфильтрованный список полетов, соответствующих заданному времени нахождения на земле
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying GroundTimeLimitFilter");
        return flights.stream()
                .filter(flight -> calculateTotalGroundTime(flight) <= maxGroundTimeInMinutes)
                .collect(Collectors.toList());
    }

    /**
     * Метод для расчета общего времени нахождения на земле между сегментами полета.
     *
     * <p>Метод проходит по каждому сегменту полета и вычисляет разницу между временем
     * прилета предыдущего сегмента и временем вылета следующего.
     *
     * @param flight полет, для которого производится расчет времени на земле
     * @return общее время нахождения на земле в минутах
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
