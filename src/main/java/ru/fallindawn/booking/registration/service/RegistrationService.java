package ru.fallindawn.booking.registration.service;

import ru.fallindawn.booking.registration.dto.RegistrationDto;

public interface RegistrationService {

    RegistrationDto makeReserve(RegistrationDto registration);
}
