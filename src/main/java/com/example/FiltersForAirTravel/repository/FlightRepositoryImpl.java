package com.example.FiltersForAirTravel.repository;

import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса {@link FlightRepository} для работы с данными о полетах.
 *
 * <p>Отмечена аннотацией {@link Repository}, что означает использование данного
 * класса в качестве компонента репозитория в Spring-приложении.
 */
@Repository
public class FlightRepositoryImpl implements FlightRepository {

    /**
     * Возвращает список всех доступных полетов.
     *
     * <p>Метод создает и возвращает фиксированный список полетов, содержащий как
     * сегменты с будущими отправлениями, так и с прошлыми.
     *
     * @return список объектов {@link Flight}, содержащий сегменты полетов
     */
    @Override
    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(List.of(new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3)))));
        flights.add(new Flight(List.of(new Segment(LocalDateTime.now().minusHours(5), LocalDateTime.now().minusHours(3)))));
        flights.add(new Flight(List.of(new Segment(LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(7)),
                new Segment(LocalDateTime.now().plusHours(9), LocalDateTime.now().plusHours(12)))));
        flights.add(new Flight(List.of(new Segment(LocalDateTime.now().plusHours(10), LocalDateTime.now().plusHours(11)))));
        return flights;
    }
}
