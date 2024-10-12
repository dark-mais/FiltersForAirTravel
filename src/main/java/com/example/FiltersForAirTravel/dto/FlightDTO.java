package com.example.FiltersForAirTravel.dto;

import java.util.List;

/**
 * Класс {@code FlightDTO} представляет собой объект передачи данных (DTO),
 * содержащий информацию о полете, включая список сегментов.
 *
 * <p>Используется для передачи данных о полетах между слоями приложения
 * или для отображения в API.
 *
 * @see SegmentDTO
 */
public class FlightDTO {

    /**
     * Список сегментов полета.
     *
     * <p>Каждый сегмент содержит информацию о конкретной части маршрута полета.
     */
    private List<SegmentDTO> segments;

    /**
     * Конструктор класса {@code FlightDTO}, который инициализирует список сегментов.
     *
     * @param segments список сегментов полета
     */
    public FlightDTO(List<SegmentDTO> segments) {
        this.segments = segments;
    }

    /**
     * Возвращает список сегментов полета.
     *
     * @return список сегментов {@link SegmentDTO}
     */
    public List<SegmentDTO> getSegments() {
        return segments;
    }

    /**
     * Возвращает строковое представление объекта {@code FlightDTO}.
     *
     * <p>Используется для удобного отображения объекта в логах или для отладки.
     *
     * @return строковое представление объекта {@code FlightDTO}
     */
    @Override
    public String toString() {
        return "FlightDTO{" +
                "segments=" + segments +
                '}';
    }
}
