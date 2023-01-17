package ru.fallindawn.booking.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fallindawn.booking.client.repository.ClientRepository;
import ru.fallindawn.booking.reservation.domain.Reservation;
import ru.fallindawn.booking.reservation.dto.ReservationDto;
import ru.fallindawn.booking.reservation.mapper.ReservationMapper;
import ru.fallindawn.booking.reservation.repository.ReservationRepository;
import ru.fallindawn.booking.room.repository.RoomRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public ReservationDto makeReserve(ReservationDto reservationDto) {
        var client = clientRepository.getReferenceById(reservationDto.getClientId());
        var room = roomRepository.getReferenceById(reservationDto.getRoomId());

        var registration = Reservation.builder()
                .client(client)
                .room(room)
                .checkIn(reservationDto.getDateFrom())
                .checkOut(reservationDto.getDateTo())
                .build();

        reservationRepository.save(registration);
        return reservationMapper.toDto(reservationRepository.save(registration));
    }
}
