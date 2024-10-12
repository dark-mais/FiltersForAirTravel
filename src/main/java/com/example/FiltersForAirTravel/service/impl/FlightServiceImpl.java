package com.example.FiltersForAirTravel.service.impl;

import com.example.FiltersForAirTravel.dto.FlightDTO;
import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.filter.CompositeFlightFilter;
import com.example.FiltersForAirTravel.repository.FlightRepository;
import com.example.FiltersForAirTravel.utils.FlightMapper;
import com.example.FiltersForAirTravel.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Сервисный класс, реализующий логику получения и фильтрации полетов.
 *
 * <p>Этот класс отмечен аннотацией {@link Service}, что указывает на его использование
 * как сервисного компонента в контексте Spring. Он использует асинхронное выполнение
 * и кеширование результатов фильтрации полетов.
 *
 * @see FlightRepository
 * @see CompositeFlightFilter
 * @see FlightMapper
 */
@Service
public class FlightServiceImpl implements FlightService {

    private static final Logger logger = LoggerFactory.getLogger(FlightServiceImpl.class);

    /**
     * Репозиторий для получения данных о полетах.
     *
     * <p>Автоматически инжектируется с помощью аннотации {@link Autowired}.
     */
    @Autowired
    private FlightRepository flightRepository;

    /**
     * Компонент для фильтрации списка полетов с применением различных правил.
     *
     * <p>Инжектируется через {@link Autowired}.
     */
    @Autowired
    private CompositeFlightFilter flightFilter;

    /**
     * Маппер для преобразования сущностей полетов в DTO.
     *
     * <p>Инжектируется с помощью аннотации {@link Autowired}.
     */
    @Autowired
    private FlightMapper flightMapper;

    /**
     * Асинхронно получает и фильтрует список полетов.
     *
     * <p>Метод помечен аннотациями {@link Async} для выполнения в отдельном потоке и
     * {@link Cacheable} для кеширования результатов под именем "filteredFlights".
     * Получает все полеты из репозитория, применяет к ним фильтры и возвращает результат
     * в виде списка DTO объектов.
     *
     * @return асинхронный результат, содержащий список отфильтрованных полетов в формате DTO
     */
    @Override
    @Async
    @Cacheable("filteredFlights")
    public CompletableFuture<List<FlightDTO>> getFilteredFlights() {
        logger.info("Fetching and filtering flights asynchronously");
        List<Flight> flights = flightRepository.getAllFlights();
        List<Flight> filteredFlights = flightFilter.filter(flights);
        List<FlightDTO> result = filteredFlights.stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(result);
    }
}
