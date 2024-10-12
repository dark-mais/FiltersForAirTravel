package com.example.FiltersForAirTravel.entity;

import java.time.LocalDateTime;

/**
 * Класс {@code Segment} представляет один сегмент полета, включающий время отправления
 * и время прибытия.
 *
 * <p>Этот класс используется для хранения информации о временных характеристиках
 * конкретного сегмента рейса.
 */
public class Segment {

    /**
     * Время отправления сегмента.
     */
    private final LocalDateTime departureDate;

    /**
     * Время прибытия сегмента.
     */
    private final LocalDateTime arrivalDate;

    /**
     * Конструктор класса {@code Segment}, инициализирующий время отправления
     * и время прибытия для данного сегмента полета.
     *
     * @param departureDate время отправления сегмента
     * @param arrivalDate время прибытия сегмента
     */
    public Segment(LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    /**
     * Возвращает время отправления сегмента.
     *
     * @return время отправления
     */
    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    /**
     * Возвращает время прибытия сегмента.
     *
     * @return время прибытия
     */
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Возвращает строковое представление сегмента, включая время отправления и прибытия.
     *
     * @return строка с временем отправления и прибытия
     */
    @Override
    public String toString() {
        return "[Departure: " + departureDate +
                ", Arrival: " + arrivalDate + "]";
    }
}
