package ru.fallindawn.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fallindawn.booking.domain.Registration;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, UUID> {

    List<Registration> findDistinctByRoomBetween(LocalDate dateFrom, LocalDate dateTo);


}
