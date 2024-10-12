package com.example.FiltersForAirTravel.service;

import com.example.FiltersForAirTravel.dto.FlightDTO;
import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.filter.CompositeFlightFilter;
import com.example.FiltersForAirTravel.repository.FlightRepository;
import com.example.FiltersForAirTravel.service.impl.FlightServiceImpl;
import com.example.FiltersForAirTravel.utils.FlightMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Тестовый класс для {@code FlightServiceImpl}, который проверяет его функциональность.
 *
 * <p>Отмечен аннотацией {@link Service}, что означает его использование как сервисный компонент
 * в Spring-приложении. Использует аннотации {@link Mock} и {@link InjectMocks} для мокирования
 * зависимостей и тестирования с использованием библиотеки Mockito.
 *
 * <p>Класс проверяет работу фильтрации полетов и преобразования данных в DTO.
 */
@Service
class FlightServiceImplTest {

    /**
     * Экземпляр сервиса для тестирования.
     *
     * <p>Автоматически инжектируется с помощью аннотации {@link InjectMocks}, что позволяет
     * выполнять тестирование с мокированными зависимостями.
     */
    @InjectMocks
    private FlightServiceImpl flightService;

    /**
     * Мок для репозитория полетов.
     *
     * <p>Аннотация {@link Mock} используется для создания мок-объекта {@link FlightRepository},
     * который необходим для тестирования без реального взаимодействия с базой данных.
     */
    @Mock
    private FlightRepository flightRepository;

    /**
     * Мок для фильтра полетов.
     *
     * <p>Аннотация {@link Mock} используется для мокирования {@link CompositeFlightFilter}, который
     * используется для фильтрации списка полетов.
     */
    @Mock
    private CompositeFlightFilter flightFilter;

    /**
     * Мок для маппера полетов.
     *
     * <p>Аннотация {@link Mock} используется для мокирования {@link FlightMapper}, который
     * преобразует объекты {@link Flight} в {@link FlightDTO}.
     */
    @Mock
    private FlightMapper flightMapper;

    /**
     * Метод, который выполняется перед каждым тестом для настройки мок-объектов.
     *
     * <p>Использует метод {@link MockitoAnnotations#openMocks(Object)}, чтобы инициализировать
     * мок-объекты перед выполнением тестов.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Тест проверяет метод {@code getFilteredFlights()} сервиса {@link FlightServiceImpl}.
     *
     * <p>Мокируется поведение зависимостей: репозиторий возвращает пустой список полетов, фильтр
     * не изменяет список, а маппер преобразует его в пустой DTO. Метод проверяет, что результат
     * вызова сервиса не null, результат выполнения пуст, а также что были вызваны соответствующие
     * методы зависимостей.
     *
     * @throws Exception если произошла ошибка при выполнении асинхронного метода.
     */
    @Test
    void testGetFilteredFlights() throws Exception {
        // Настройка мок-объектов
        List<Flight> flights = Collections.emptyList();
        when(flightRepository.getAllFlights()).thenReturn(flights);
        when(flightFilter.filter(flights)).thenReturn(flights);
        when(flightMapper.toDto(any())).thenReturn(new FlightDTO(Collections.emptyList()));

        // Выполнение тестируемого метода
        CompletableFuture<List<FlightDTO>> result = flightService.getFilteredFlights();

        // Проверка результата
        assertNotNull(result);
        assertTrue(result.get().isEmpty());
        verify(flightRepository).getAllFlights();
        verify(flightFilter).filter(flights);
    }
}
