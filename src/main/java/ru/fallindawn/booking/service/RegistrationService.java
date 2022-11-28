package ru.fallindawn.booking.service;

import org.springframework.stereotype.Service;
import ru.fallindawn.booking.dto.RegistrationDto;

@Service
public interface RegistrationService {

    RegistrationDto makeReserve(RegistrationDto registration);
}
