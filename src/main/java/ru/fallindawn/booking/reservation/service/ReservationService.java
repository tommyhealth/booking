package ru.fallindawn.booking.reservation.service;

import ru.fallindawn.booking.reservation.dto.ReservationDto;

public interface ReservationService {

    ReservationDto makeReserve(ReservationDto registration);
}
