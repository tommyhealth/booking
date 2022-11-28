package ru.fallindawn.booking.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import ru.fallindawn.booking.domain.Registration;
import ru.fallindawn.booking.dto.RegistrationDto;

@Mapper(componentModel = "spring")
@Component
public interface RegistrationMapper {

    RegistrationDto toDto(Registration registrationDto);
}
