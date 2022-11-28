package ru.fallindawn.booking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fallindawn.booking.dto.RegistrationDto;

@RequestMapping("/registration")
public interface RegistrationController {

    @PostMapping
    ResponseEntity<RegistrationDto> makeReserve(@RequestBody RegistrationDto makeReserveDto);
}
