package com.example.FiltersForAirTravel.dto;

import java.time.LocalDateTime;

/**
 * Класс {@code SegmentDTO} представляет сегмент полета с информацией о
 * времени отправления и прибытия.
 *
 * <p>Используется для передачи данных о сегменте полета в контексте бизнес-логики,
 * где важны даты и время отправления и прибытия.
 */
public class SegmentDTO {

    /**
     * Дата и время отправления сегмента полета.
     */
    private LocalDateTime departureDate;

    /**
     * Дата и время прибытия сегмента полета.
     */
    private LocalDateTime arrivalDate;

    /**
     * Конструктор для создания экземпляра {@code SegmentDTO}.
     *
     * @param departureDate дата и время отправления
     * @param arrivalDate дата и время прибытия
     */
    public SegmentDTO(LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    /**
     * Возвращает дату и время отправления.
     *
     * @return дата и время отправления
     */
    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    /**
     * Возвращает дату и время прибытия.
     *
     * @return дата и время прибытия
     */
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Возвращает строковое представление объекта {@code SegmentDTO}.
     *
     * @return строка, содержащая дату и время отправления и прибытия
     */
    @Override
    public String toString() {
        return "SegmentDTO{" +
                "departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
