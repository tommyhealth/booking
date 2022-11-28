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
        //TODO предварительно положи в таблицу с клиентами  клиентов для последующих проверок
        //TODO: Из репозитория клиетов достать челика по registration.clientId
        // TODO: Из репозитория комнат достать комнату по registration.roomId
        //TODO: Из репозитория комнат достать комнату по registration.roomId
        //TODO: Заводим новый объект Registration (не ДТО. ДТО и так приходит в метод), заполняеv
        // данными (клиент и комната (их объекты которые мы ранее получили) и даты бронирования )
        //TODO: сохраняем полчившееся (registrationRepository.save(объект_который_заполнили_на_предыдущем шаге))
        //TODO: Проверить что забронрованная комната больше не появляется при поиске всех комнат
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
