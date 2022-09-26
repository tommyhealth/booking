package ru.fallindawn.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fallindawn.booking.domain.Registration;

import java.util.UUID;

public interface RegistrationRepository extends JpaRepository<Registration, UUID> {

}
