package ru.fallindawn.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import ru.fallindawn.booking.dto.RegistrationDto;
import ru.fallindawn.booking.service.RegistrationService;


public class RegistrationControllerImpl implements RegistrationController {

    @Autowired
    private RegistrationService registrationService;


    @Override
    public ResponseEntity<RegistrationDto> makeReserve(RegistrationDto makeReserveDto) {
        return ResponseEntity.ok(registrationService.makeReserve(makeReserveDto));
    }
}
