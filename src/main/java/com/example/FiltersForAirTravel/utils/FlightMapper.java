package com.example.FiltersForAirTravel.utils;

import com.example.FiltersForAirTravel.dto.FlightDTO;
import com.example.FiltersForAirTravel.dto.SegmentDTO;
import com.example.FiltersForAirTravel.entity.Flight;
import com.example.FiltersForAirTravel.entity.Segment;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Компонент для маппинга объектов {@link Flight} в объекты {@link FlightDTO}.
 *
 * <p>Класс помечен аннотацией {@link Component}, что указывает на его использование
 * как бина в контексте Spring. Он преобразует объекты полетов в DTO-объекты для
 * дальнейшей передачи в сервисы или контроллеры.
 */
@Component
public class FlightMapper {

    /**
     * Преобразует объект {@link Flight} в объект {@link FlightDTO}.
     *
     * <p>Этот метод используется для создания DTO-представления полета на основе
     * данных о сегментах полета. Каждый сегмент также преобразуется в свой DTO.
     *
     * @param flight объект {@link Flight}, который необходимо преобразовать
     * @return объект {@link FlightDTO}, содержащий список сегментов в формате DTO
     */
    public FlightDTO toDto(Flight flight) {
        return new FlightDTO(flight.getSegments().stream()
                .map(this::toSegmentDto)
                .collect(Collectors.toList()));
    }

    /**
     * Преобразует объект {@link Segment} в объект {@link SegmentDTO}.
     *
     * <p>Этот метод используется для преобразования отдельных сегментов полета
     * в их DTO-представление, с указанием времени вылета и прилета.
     *
     * @param segment объект {@link Segment}, который необходимо преобразовать
     * @return объект {@link SegmentDTO}, содержащий информацию о времени вылета и прилета
     */
    private SegmentDTO toSegmentDto(Segment segment) {
        return new SegmentDTO(segment.getDepartureDate(), segment.getArrivalDate());
    }
}
