package com.example.FiltersForAirTravel.controller;

import com.example.FiltersForAirTravel.dto.FlightDTO;
import com.example.FiltersForAirTravel.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Тестовый класс для {@link FlightController}, проверяющий его функциональность.
 *
 * <p>Использует аннотации {@link InjectMocks} и {@link Mock} для создания mock-объектов
 * и проверки взаимодействий между контроллером и сервисом.
 */
class FlightControllerTest {

    /**
     * Контроллер полетов, тестируемый в этом классе.
     *
     * <p>Инициализируется с помощью аннотации {@link InjectMocks}, что позволяет внедрять
     * mock-объекты в тестируемый объект.
     */
    @InjectMocks
    private FlightController flightController;

    /**
     * Mock-объект сервиса полетов, используемый для имитации работы сервиса в тестах.
     *
     * <p>Создается с использованием аннотации {@link Mock}.
     */
    @Mock
    private FlightService flightService;

    /**
     * Метод инициализации, вызываемый перед каждым тестом.
     *
     * <p>Открывает mock-объекты с помощью {@link MockitoAnnotations#openMocks(Object)},
     * чтобы корректно настроить mock-объекты перед тестированием.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Тест для метода {@link FlightController#getFilteredFlights()}.
     *
     * <p>Проверяет, что метод возвращает пустой список полетов, если сервис возвращает
     * пустой список. Использует mock для настройки поведения сервиса.
     */
    @Test
    void testGetFilteredFlights() {
        // Настройка поведения mock
        when(flightService.getFilteredFlights()).thenReturn(CompletableFuture.completedFuture(Collections.emptyList()));

        // Вызов метода контроллера
        DeferredResult<List<FlightDTO>> result = flightController.getFilteredFlights();

        // Преобразование результата в тип List и проверка
        List<FlightDTO> flightList = (List<FlightDTO>) result.getResult();
        assertNotNull(flightList);
        assertTrue(flightList.isEmpty());
    }
}
