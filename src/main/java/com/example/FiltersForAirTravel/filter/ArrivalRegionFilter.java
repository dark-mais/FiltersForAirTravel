package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code ArrivalRegionFilter} применяется для фильтрации полетов,
 * сегменты которых прибывают в указанный регион.
 *
 * <p>Этот класс реализует интерфейс {@link FlightFilter} и обеспечивает
 * фильтрацию полетов на основе региона, указанного в дате прибытия сегментов.
 *
 * <p>Используется для того, чтобы оставить только те полеты, которые
 * прибывают в заданный регион.
 *
 * @see FlightFilter
 */
public class ArrivalRegionFilter implements FlightFilter {

    /**
     * Логгер для записи информации о процессе фильтрации.
     */
    private static final Logger logger = LoggerFactory.getLogger(ArrivalRegionFilter.class.getName());

    /**
     * Регион, по которому фильтруются полеты.
     */
    private final String region;

    /**
     * Конструктор класса {@code ArrivalRegionFilter}, который задает регион для фильтрации.
     *
     * @param region регион, который будет использоваться для фильтрации полетов
     */
    public ArrivalRegionFilter(String region) {
        this.region = region;
    }

    /**
     * Метод для фильтрации полетов по региону прибытия.
     *
     * <p>Применяет фильтрацию ко всем сегментам каждого полета, оставляя только те полеты,
     * которые имеют сегменты с датой прибытия, содержащей указанный регион.
     *
     * @param flights список полетов для фильтрации
     * @return отфильтрованный список полетов, которые соответствуют указанному региону
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying ArrivalRegionFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().toString().contains(region)))
                .collect(Collectors.toList());
    }
}
