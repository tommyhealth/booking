package ru.fallindawn.booking.room.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fallindawn.booking.registration.domain.Registration;
import ru.fallindawn.booking.registration.repository.RegistrationRepository;
import ru.fallindawn.booking.room.dto.CreateRoomCommand;
import ru.fallindawn.booking.room.dto.RoomDto;
import ru.fallindawn.booking.room.dto.SearchRoomQuery;
import ru.fallindawn.booking.room.mapper.RoomMapper;
import ru.fallindawn.booking.room.repository.RoomRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.UUID;
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

    @Override
    public List<RoomDto> findAll() {
        log.info("Enter: findAll()");
        var allRooms = roomRepository.findAll().stream()
                .map(room -> roomMapper.toDto(room))
                .toList();
        log.info("Exit: findAll(). Found rooms: " + allRooms);
        return allRooms;
    }

    @Override
    @Transactional
    public RoomDto createRoom(CreateRoomCommand roomDto) {
        log.info("Enter: createRoom(). Room from command: {}", roomDto);
        var createdRoom = roomRepository.save(roomMapper.toEntity(roomDto));
        log.info("Exit: createRoom(). Result room: {}", createdRoom);
        return roomMapper.toDto(createdRoom);
    }

    @Override
    public List<RoomDto> findByDate(SearchRoomQuery searchRoomQuery) {
        log.info("Enter: findByDate(). From query: {}", searchRoomQuery);
        var reservedRooms = findReservedRooms(searchRoomQuery);
        var foundRooms = getNonReservedRooms(searchRoomQuery, reservedRooms);
        log.info("Exit: findByDate(). Found rooms: {}", foundRooms);
        return foundRooms;
    }

    private Set<UUID> findReservedRooms(SearchRoomQuery searchRoomQuery) {
        var dateFrom = searchRoomQuery.getDateFrom();
        var dateTo = searchRoomQuery.getDateTo();
        return registrationRepository.findDistinctBetween(dateFrom, dateTo).stream()
                .map(Registration::getRoomId)
                .collect(Collectors.toUnmodifiableSet());
    }

    private List<RoomDto> getNonReservedRooms(SearchRoomQuery searchRoomQuery, Set<UUID> reservedRooms) {
        var capacity = searchRoomQuery.getCapacity();
        return roomRepository.findByCapacity(capacity).stream()
                .filter(room -> !reservedRooms.contains(room.getId()))
                .map(roomMapper::toDto)
                .toList();
    }
}
