package com.example.FiltersForAirTravel.entity;

import java.util.Collections;
import java.util.List;

/**
 * Класс {@code Flight} представляет собой полет, состоящий из нескольких сегментов.
 *
 * <p>Каждый полет включает в себя один или несколько сегментов, которые отражают
 * последовательные этапы путешествия. Полет состоит из неизменяемого списка сегментов,
 * которые задаются при создании объекта.
 *
 * @see Segment
 */
public class Flight {

    /**
     * Список сегментов, составляющих полет.
     *
     * <p>Список сегментов является неизменяемым, что гарантируется использованием
     * метода {@code Collections.unmodifiableList()}.
     */
    private final List<Segment> segments;

    /**
     * Конструктор создает новый объект {@code Flight} с указанным списком сегментов.
     *
     * <p>Список сегментов передается как аргумент и становится неизменяемым.
     *
     * @param segments список сегментов, составляющих полет
     * @throws NullPointerException если список сегментов равен {@code null}
     */
    public Flight(List<Segment> segments) {
        this.segments = Collections.unmodifiableList(segments);
    }

    /**
     * Возвращает список сегментов, составляющих полет.
     *
     * <p>Этот метод возвращает неизменяемый список сегментов, которые были
     * переданы при создании объекта {@code Flight}.
     *
     * @return неизменяемый список сегментов полета
     */
    public List<Segment> getSegments() {
        return segments;
    }

    /**
     * Возвращает строковое представление списка сегментов полета.
     *
     * <p>Метод возвращает строковое представление сегментов в формате списка,
     * где каждый элемент списка является сегментом полета.
     *
     * @return строковое представление сегментов полета
     */
    @Override
    public String toString() {
        return segments.toString();
    }
}
