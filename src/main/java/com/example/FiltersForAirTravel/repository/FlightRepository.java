package com.example.FiltersForAirTravel.repository;

import com.example.FiltersForAirTravel.entity.Flight;

import java.util.List;

/**
 * Интерфейс для работы с данными полетов.
 *
 * <p>Предоставляет метод для получения списка всех доступных полетов.
 * Этот интерфейс может быть реализован для работы с различными источниками данных.
 */
public interface FlightRepository {

    /**
     * Возвращает список всех доступных полетов.
     *
     * <p>Этот метод используется для получения всех полетов, доступных в системе,
     * без каких-либо фильтров или ограничений.
     *
     * @return список объектов {@link Flight}, представляющих полеты
     */
    List<Flight> getAllFlights();
}
