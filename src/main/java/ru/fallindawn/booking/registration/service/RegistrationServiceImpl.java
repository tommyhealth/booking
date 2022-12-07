package ru.fallindawn.booking.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fallindawn.booking.client.domain.Client;
import ru.fallindawn.booking.registration.domain.Registration;
import ru.fallindawn.booking.room.domain.Room;
import ru.fallindawn.booking.registration.dto.RegistrationDto;
import ru.fallindawn.booking.registration.mapper.RegistrationMapper;
import ru.fallindawn.booking.client.repository.ClientRepository;
import ru.fallindawn.booking.registration.repository.RegistrationRepository;
import ru.fallindawn.booking.room.repository.RoomRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RegistrationMapper registrationMapper;

    @Override
    public RegistrationDto makeReserve(RegistrationDto registrationDto) {

        Client client = clientRepository.getReferenceById(registrationDto.getClientId());
        Room room = roomRepository.getReferenceById(registrationDto.getRoomId());

        Registration registration = Registration.builder()
                .client(client)
                .room(room)
                .checkIn(registrationDto.getDateFrom())
                .checkOut(registrationDto.getDateTo())
                .build();

        registrationRepository.save(registration);
        return registrationMapper.toDto(registrationRepository.save(registration));
    }
}
