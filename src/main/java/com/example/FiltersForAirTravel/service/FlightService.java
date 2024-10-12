package com.example.FiltersForAirTravel.service;

import com.example.FiltersForAirTravel.dto.FlightDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Интерфейс {@code FlightService} предназначен для работы с полетами,
 * предоставляя методы для получения отфильтрованных данных о полетах.
 *
 * <p>Реализующий класс должен обеспечить логику фильтрации полетов
 * с учетом установленных правил и асинхронной обработки данных.
 */
public interface FlightService {

    /**
     * Асинхронный метод для получения списка отфильтрованных полетов.
     *
     * <p>Возвращает {@code CompletableFuture}, который содержит
     * список объектов {@link FlightDTO}, представляющих данные о полетах.
     * Метод позволяет фильтровать полеты на основе заранее определённых критериев.
     *
     * @return {@code CompletableFuture}, который содержит список
     * отфильтрованных полетов в виде объектов {@link FlightDTO}
     */
    CompletableFuture<List<FlightDTO>> getFilteredFlights();
}
