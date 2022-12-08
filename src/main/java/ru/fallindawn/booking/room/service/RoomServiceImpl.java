package ru.fallindawn.booking.room.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fallindawn.booking.registration.domain.Registration;
import ru.fallindawn.booking.room.dto.RoomDto;
import ru.fallindawn.booking.room.dto.SearchRequestDto;
import ru.fallindawn.booking.registration.repository.RegistrationRepository;
import ru.fallindawn.booking.room.mapper.RoomMapper;
import ru.fallindawn.booking.room.repository.RoomRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RoomMapper roomMapper;

    public List<RoomDto> findAll() {
        log.info("Enter: findAll()");
        var allRooms = roomRepository.findAll().stream()
                .map(room -> roomMapper.toDto(room))
                .collect(Collectors.toList());
        log.info("Exit: findAll(). Finded Rooms: " + allRooms);
        return allRooms;
    }

    @Override
    @Transactional
    public RoomDto createRoom(RoomDto roomDto) {
        log.info("Enter: createRoom(). Room DTO: {}", roomDto);
        var createdRoom = roomRepository.save(roomMapper.toEntity(roomDto));
        log.info("Exit: createRoom(). Result room: {}", createdRoom);
        return roomMapper.toDto(createdRoom);
    }

    public List<RoomDto> findByData(SearchRequestDto searchRequestDto) {
        var dateFrom = searchRequestDto.getDateFrom();
        var dateTo = searchRequestDto.getDateTo();
        var reservedRooms = registrationRepository.findDistinctBetween(dateFrom, dateTo).stream()
                .map(Registration::getRoomId)
                .collect(Collectors.toSet());

        return roomRepository.findAllByCapacity(searchRequestDto.getCapacity()).stream()
                .filter(room -> !reservedRooms.contains(room.getId()))
                .map(room -> roomMapper.toDto(room))
                .collect(Collectors.toList());
    }
}
