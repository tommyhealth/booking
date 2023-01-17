package ru.fallindawn.booking.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.fallindawn.booking.reservation.dto.ReservationDto;
import ru.fallindawn.booking.reservation.service.ReservationService;

@RestController
public class ReservationControllerImpl implements ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Override
    public ReservationDto makeReserve(ReservationDto makeReserveDto) {
        return reservationService.makeReserve(makeReserveDto);
    }
}
