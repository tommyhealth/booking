package ru.fallindawn.booking.registration.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import ru.fallindawn.booking.registration.domain.Registration;
import ru.fallindawn.booking.registration.dto.RegistrationDto;

@Mapper(componentModel = "spring")
@Component
public interface RegistrationMapper {

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "roomId", source = "room.id")
    RegistrationDto toDto(Registration registrationDto);
}
