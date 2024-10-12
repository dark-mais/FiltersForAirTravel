package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code MaxSegmentsFilter} применяет фильтрацию полетов по максимальному
 * количеству сегментов. Если количество сегментов в полете превышает заданное значение,
 * полет исключается из результата.
 *
 * <p>Класс использует логгер для записи операций фильтрации.
 *
 * <p>Отмечен аннотацией {@link Service}, что указывает на его использование в
 * качестве сервисного компонента для фильтрации полетов.
 *
 * @see Flight
 * @see FlightFilter
 */
public class MaxSegmentsFilter implements FlightFilter {

    /** Логгер для записи информации о процессе фильтрации. */
    private static final Logger logger = LoggerFactory.getLogger(MaxSegmentsFilter.class.getName());

    /** Максимальное допустимое количество сегментов в полете. */
    private final int maxSegments;

    /**
     * Конструктор класса {@code MaxSegmentsFilter}.
     *
     * @param maxSegments максимальное количество сегментов, которое может содержать полет
     */
    public MaxSegmentsFilter(int maxSegments) {
        this.maxSegments = maxSegments;
    }

    /**
     * Применяет фильтрацию к списку полетов.
     *
     * <p>Если количество сегментов в полете превышает значение {@code maxSegments}, такой полет
     * исключается из результирующего списка.
     *
     * @param flights список полетов для фильтрации
     * @return список полетов, каждый из которых имеет не более {@code maxSegments} сегментов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Применение фильтра MaxSegmentsFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().size() <= maxSegments)
                .collect(Collectors.toList());
    }
}
