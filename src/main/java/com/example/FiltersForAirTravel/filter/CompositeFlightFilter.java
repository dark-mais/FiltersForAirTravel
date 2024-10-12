package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс {@code CompositeFlightFilter} реализует интерфейс {@link FlightFilter}
 * и позволяет применять несколько фильтров к списку полетов последовательно.
 *
 * <p>Каждый добавленный фильтр применяется к результату предыдущего фильтра,
 * что позволяет комбинировать фильтры для более гибкой фильтрации данных.
 *
 * <p>Класс использует аннотацию {@link Logger} для ведения журнала операций.
 */
public class CompositeFlightFilter implements FlightFilter {

    /**
     * Логгер для записи информации о выполнении операций класса.
     */
    private static final Logger logger = LoggerFactory.getLogger(CompositeFlightFilter.class.getName());

    /**
     * Список фильтров, которые будут применяться к полетам.
     */
    private final List<FlightFilter> filters = new ArrayList<>();

    /**
     * Добавляет новый фильтр в список для применения.
     *
     * <p>Каждый фильтр будет применяться последовательно в порядке добавления.
     *
     * @param filter фильтр, который нужно добавить
     */
    public void addFilter(FlightFilter filter) {
        filters.add(filter);
    }

    /**
     * Применяет все добавленные фильтры к списку полетов.
     *
     * <p>Каждый фильтр применяет изменения к списку полетов на основе заданных правил.
     * Ведется логгирование процесса фильтрации для отслеживания последовательности действий.
     *
     * @param flights список полетов для фильтрации
     * @return список полетов после применения всех фильтров
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        logger.info("Applying composite filters");
        List<Flight> result = new ArrayList<>(flights);
        for (FlightFilter filter : filters) {
            result = filter.filter(result);
        }
        return result;
    }
}
