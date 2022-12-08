package ru.fallindawn.booking.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.fallindawn.booking.client.dto.ClientDto;
import ru.fallindawn.booking.client.service.ClientService;

@RestController
public class ClientControllerImpl implements ClientController {

    @Autowired
    private ClientService clientService;

    @Override
    public ClientDto registerClient(ClientDto clientDto) {
        return clientService.registerClient(clientDto);
    }
}
