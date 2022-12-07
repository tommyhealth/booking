package ru.fallindawn.booking.client.service;

import org.springframework.stereotype.Service;
import ru.fallindawn.booking.client.dto.ClientDto;

@Service
public interface ClientService {
    ClientDto saveClient(ClientDto clientDto);
}
