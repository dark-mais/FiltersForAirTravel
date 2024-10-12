package com.example.FiltersForAirTravel.utils;

import com.example.FiltersForAirTravel.dto.FlightDTO;
import com.example.FiltersForAirTravel.dto.SegmentDTO;
import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс {@code FlightMapperTest} предназначен для тестирования методов маппера
 * {@link FlightMapper}, который преобразует объекты {@link Flight} в объекты {@link FlightDTO}.
 *
 * <p>Данный тестовый класс проверяет корректность преобразования данных
 * между объектами модели и объектами передачи данных (DTO).
 */
class FlightMapperTest {

    /**
     * Экземпляр маппера, который будет тестироваться.
     */
    private FlightMapper flightMapper;

    /**
     * Инициализация маппера перед каждым тестом.
     *
     * <p>Создает новый экземпляр {@link FlightMapper}, который будет
     * использоваться в тестах.
     */
    @BeforeEach
    void setUp() {
        flightMapper = new FlightMapper();
    }

    /**
     * Тестирует метод {@link FlightMapper#toDto(Flight)} с полетом, который
     * содержит один сегмент.
     *
     * <p>Тест проверяет, что объект {@link FlightDTO} создается корректно,
     * а данные сегмента полета корректно маппируются в сегмент DTO.
     */
    @Test
    void testToDto() {
        // Создаем сегмент с временем отправления и прибытия
        Segment segment = new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        Flight flight = new Flight(List.of(segment));

        // Преобразуем в DTO
        FlightDTO flightDTO = flightMapper.toDto(flight);

        // Проверяем корректность преобразования
        assertNotNull(flightDTO);
        assertEquals(1, flightDTO.getSegments().size());

        SegmentDTO segmentDTO = flightDTO.getSegments().get(0);
        assertEquals(segment.getDepartureDate(), segmentDTO.getDepartureDate());
        assertEquals(segment.getArrivalDate(), segmentDTO.getArrivalDate());
    }

    /**
     * Тестирует метод {@link FlightMapper#toDto(Flight)} для полета без сегментов.
     *
     * <p>Тест проверяет, что при преобразовании полета без сегментов
     * объект {@link FlightDTO} создается корректно и список сегментов в нем пуст.
     */
    @Test
    void testEmptyFlightToDto() {
        // Создаем полет без сегментов
        Flight flight = new Flight(List.of());

        // Преобразуем в DTO
        FlightDTO flightDTO = flightMapper.toDto(flight);

        // Проверяем корректность преобразования
        assertNotNull(flightDTO);
        assertTrue(flightDTO.getSegments().isEmpty());
    }
}
