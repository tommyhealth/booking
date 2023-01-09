package ru.fallindawn.booking.room.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.fallindawn.booking.room.domain.Room;
import ru.fallindawn.booking.room.dto.CreateRoomCommand;
import ru.fallindawn.booking.room.dto.RoomDto;

@Mapper(
        componentModel = "spring",
        uses = RoomTypeMapper.class
)
@Component
public interface RoomMapper extends RoomTypeMapper {

    String GENERATE_UUID_EXPRESSION = "java(java.util.UUID.randomUUID())";

    RoomDto toDto(Room room);

    Room toEntity(RoomDto roomDto);

    @Mapping(target = "id", expression = GENERATE_UUID_EXPRESSION)
    Room toEntity(CreateRoomCommand createRoomCommand);
}
