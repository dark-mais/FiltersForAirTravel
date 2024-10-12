package com.example.FiltersForAirTravel.filter;

import com.example.FiltersForAirTravel.entity.Flight;

import java.util.List;

/**
 * Интерфейс для фильтрации списка полетов.
 *
 * <p>Реализующие классы должны предоставлять логику фильтрации полетов на
 * основе различных критериев. Цель интерфейса — обеспечить общую структуру
 * для всех фильтров, которые могут применяться к списку полетов.
 *
 * @see Flight
 */
public interface FlightFilter {

    /**
     * Применяет фильтр к списку полетов.
     *
     * <p>Реализующий класс должен предоставлять конкретные критерии фильтрации.
     * Метод должен возвращать отфильтрованный список полетов на основе
     * заданных правил.
     *
     * @param flights список полетов для фильтрации
     * @return отфильтрованный список полетов
     * @throws IllegalArgumentException если список полетов null
     */
    List<Flight> filter(List<Flight> flights);
}
