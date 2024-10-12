package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс {@code NightFlightFilter} реализует интерфейс {@link FlightFilter} и
 * применяется для фильтрации полетов, которые выполняются в дневное время.
 *
 * <p>Этот фильтр исключает ночные рейсы, считая ночными те рейсы, у которых
 * время отправления находится за пределами интервала с 6:00 до 22:00.
 *
 * <p>Отмечен логированием с использованием {@link Logger}, чтобы отслеживать
 * процесс фильтрации.
 *
 * @see FlightFilter
 */
public class NightFlightFilter implements FlightFilter {

    /**
     * Логгер для записи информации о выполнении фильтрации.
     */
    private static final Logger logger = LoggerFactory.getLogger(NightFlightFilter.class.getName());

    /**
     * Применяет фильтр к списку полетов, исключая ночные полеты.
     *
     * <p>Метод проходит по всем сегментам каждого полета и проверяет, чтобы
     * время отправления каждого сегмента было в пределах 6:00 и 22:00.
     *
     * @param flights список полетов для фильтрации
     * @return отфильтрованный список полетов без ночных рейсов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying NightFlightFilter");
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> isNotNightFlight(segment)))
                .collect(Collectors.toList());
    }

    /**
     * Проверяет, что сегмент не является ночным полетом.
     *
     * <p>Полет считается дневным, если время отправления находится в интервале
     * с 6:00 до 22:00.
     *
     * @param segment сегмент полета для проверки
     * @return {@code true}, если полет не является ночным, иначе {@code false}
     */
    private boolean isNotNightFlight(Segment segment) {
        int hourOfDeparture = segment.getDepartureDate().getHour();
        return hourOfDeparture >= 6 && hourOfDeparture <= 22; // Не ночной полет
    }
}
