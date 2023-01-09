package ru.fallindawn.booking.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.fallindawn.booking.registration.dto.RegistrationDto;
import ru.fallindawn.booking.registration.service.RegistrationService;

@RestController
public class RegistrationControllerImpl implements RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Override
    public RegistrationDto makeReserve(RegistrationDto makeReserveDto) {
        return registrationService.makeReserve(makeReserveDto);
    }
}
