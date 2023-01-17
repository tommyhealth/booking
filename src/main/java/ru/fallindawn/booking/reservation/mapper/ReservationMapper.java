package ru.fallindawn.booking.reservation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import ru.fallindawn.booking.reservation.domain.Reservation;
import ru.fallindawn.booking.reservation.dto.ReservationDto;

@Mapper(componentModel = "spring")
@Component
public interface ReservationMapper {

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "roomId", source = "room.id")
    @Mapping(target = "dateFrom", source = "checkIn")
    @Mapping(target = "dateTo", source = "checkOut")
    ReservationDto toDto(Reservation reservation);
}
