package ru.fallindawn.booking.user.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import ru.fallindawn.booking.AbstractIntegrationTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.fallindawn.booking.user.repository.UsersTestEntities.USER_1;
import static ru.fallindawn.booking.user.repository.UsersTestEntities.USER_2;

@SpringBootTest
@DirtiesContext
@Transactional
@WithMockUser(username = "user")
class UsersRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    @DisplayName("findByLogin two users in DB user with same login")
    void findByLogin_twoUsersInDB_userWithSameLogin() {
        usersRepository.saveAll(List.of(USER_1, USER_2));
        var result = usersRepository.findByLogin("user1");
        assertEquals("user1", result.getLogin());
    }

    @Test
    @DisplayName("findByLogin two_users_in_DB_user not_found")
    void findByLogin_twoUsersInDB_userNotFound() {
        usersRepository.saveAll(List.of(USER_1, USER_2));
        var result = assertThrows(UsernameNotFoundException.class, () -> usersRepository.findByLogin("user3"));
        assertEquals("Login user3 is not found", result.getMessage());
    }

    @Test
    @DisplayName("existsByLogin one_user_in_DB true")
    void existsByLogin_oneUserInDB_true() {
        usersRepository.saveAll(List.of(USER_1, USER_2));
        var result = usersRepository.existsByLogin("user1");
        assertTrue(result);
    }
}
