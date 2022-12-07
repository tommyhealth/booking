package ru.fallindawn.booking.client.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fallindawn.booking.client.dto.ClientDto;

@RequestMapping("/client")
public interface ClientController {

    @PostMapping
    ClientDto saveClient(@RequestBody ClientDto clientDto);

}
