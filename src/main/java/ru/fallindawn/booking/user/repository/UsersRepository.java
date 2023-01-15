package ru.fallindawn.booking.user.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import ru.fallindawn.booking.user.domain.Users;

import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {

    @EntityGraph(attributePaths = { "roles" })
    Optional<Users> findFirstByLogin(String login);

    default Users findByLogin(String login) {
        var lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
        return findFirstByLogin(lowercaseLogin)
                .orElseThrow(() -> new UsernameNotFoundException("Login " + login + " is not found"));
    }

    Boolean existsByLogin(String login);
}
