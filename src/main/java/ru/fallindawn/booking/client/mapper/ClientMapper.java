package ru.fallindawn.booking.client.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.fallindawn.booking.client.domain.Client;
import ru.fallindawn.booking.client.dto.ClientDto;

@Mapper(componentModel = "spring")
@Component
public interface ClientMapper {

    ClientDto toDto (Client client);

    Client toEntity(ClientDto clientDto);
}
