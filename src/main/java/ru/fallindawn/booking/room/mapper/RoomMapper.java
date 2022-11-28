package ru.fallindawn.booking.room.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.fallindawn.booking.room.domain.Room;
import ru.fallindawn.booking.room.dto.RoomDto;

@Mapper(componentModel = "spring")
@Component
public interface RoomMapper {

    RoomDto toDto(Room room);

    Room toEntity(RoomDto roomDto);
}
