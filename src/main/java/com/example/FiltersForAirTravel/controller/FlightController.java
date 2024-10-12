package com.example.FiltersForAirTravel.controller;

import com.example.FiltersForAirTravel.dto.FlightDTO;
import com.example.FiltersForAirTravel.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Контроллер для обработки запросов, связанных с авиаперелетами.
 *
 * <p>Этот контроллер предоставляет REST API для получения отфильтрованных перелетов.
 * Отмечен аннотацией {@link RestController}, что указывает на то, что класс является
 * REST-контроллером, а аннотация {@link RequestMapping} указывает базовый путь для
 * всех его методов.
 *
 * <p>Логгирование осуществляется с помощью {@link Logger}, а кэширование результатов
 * реализовано через аннотацию {@link Cacheable}.
 *
 * @see FlightService
 */
@RestController
@RequestMapping("/api/flights")
public class FlightController {

    /**
     * Логгер для записи информации о процессе выполнения запросов.
     */
    private static final Logger logger = LoggerFactory.getLogger(FlightController.class);

    /**
     * Сервис для работы с авиаперелетами.
     *
     * <p>Инициализируется с помощью аннотации {@link Autowired}, что указывает на
     * автоматическую инъекцию зависимостей Spring Framework.
     */
    @Autowired
    private FlightService flightService;

    /**
     * Получить список отфильтрованных авиаперелетов.
     *
     * <p>Этот метод обрабатывает GET-запрос на путь "/filtered" и возвращает
     * отложенный результат в виде списка объектов {@link FlightDTO}.
     *
     * <p>Метод кэширует результат с помощью аннотации {@link Cacheable}, чтобы
     * повысить производительность при повторных запросах.
     *
     * <p>Асинхронное выполнение запроса осуществляется с помощью {@link CompletableFuture},
     * что позволяет избежать блокировки основного потока.
     *
     * @return отложенный результат со списком отфильтрованных авиаперелетов
     */
    @Operation(summary = "Получить отфильтрованные авиаперелеты")
    @GetMapping("/filtered")
    @Cacheable("filteredFlights")
    public DeferredResult<List<FlightDTO>> getFilteredFlights() {
        logger.info("Fetching filtered flights...");
        DeferredResult<List<FlightDTO>> output = new DeferredResult<>();
        CompletableFuture<List<FlightDTO>> future = flightService.getFilteredFlights();
        future.thenAccept(output::setResult);
        return output;
    }
}
