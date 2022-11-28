package ru.fallindawn.booking.registration.service;

import org.springframework.stereotype.Service;
import ru.fallindawn.booking.registration.dto.RegistrationDto;

@Service
public interface RegistrationService {

    RegistrationDto makeReserve(RegistrationDto registration);
}
