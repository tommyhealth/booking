package ru.fallindawn.booking.registration.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fallindawn.booking.registration.dto.RegistrationDto;

@RequestMapping("/registration")
public interface RegistrationController {

    @PostMapping
    RegistrationDto makeReserve(@RequestBody RegistrationDto makeReserveDto);
}
