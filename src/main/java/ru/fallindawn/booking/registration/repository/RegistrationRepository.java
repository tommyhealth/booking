package ru.fallindawn.booking.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.fallindawn.booking.registration.domain.Registration;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, UUID> {

    @Query(value = "SELECT DISTINCT * FROM registration WHERE (check_in >= ?1 and check_out <= ?2)", nativeQuery = true)
    Set<Registration> findDistinctBetween(Instant dateFrom, Instant dateTo);
}
