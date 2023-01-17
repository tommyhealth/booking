package ru.fallindawn.booking.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.fallindawn.booking.reservation.domain.Reservation;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    @Query(value = """
            SELECT DISTINCT *
              FROM reservation
             WHERE (check_in < ?2 AND check_out > ?1)
             """, nativeQuery = true)
    Set<Reservation> findDistinctBetween(Instant dateFrom, Instant dateTo);
}
