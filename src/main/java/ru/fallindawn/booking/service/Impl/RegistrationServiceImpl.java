package ru.fallindawn.booking.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fallindawn.booking.domain.Client;
import ru.fallindawn.booking.domain.Registration;
import ru.fallindawn.booking.domain.Room;
import ru.fallindawn.booking.dto.RegistrationDto;
import ru.fallindawn.booking.mapper.RegistrationMapper;
import ru.fallindawn.booking.repository.ClientRepository;
import ru.fallindawn.booking.repository.RegistrationRepository;
import ru.fallindawn.booking.repository.RoomRepository;
import ru.fallindawn.booking.service.RegistrationService;

import java.time.Instant;
import java.util.UUID;

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
        Registration registration = new Registration();
        registration.setClient(client);
        registration.setRoom(room);
        registration.setCheckIn(registrationDto.getDateFrom());
        registration.setCheckOut(registrationDto.getDateTo());
        registrationRepository.save(registration);
        return registrationMapper.toDto(registrationRepository.save(registration));
    }
}
