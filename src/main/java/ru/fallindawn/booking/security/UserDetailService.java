package ru.fallindawn.booking.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fallindawn.booking.user.domain.Role;
import ru.fallindawn.booking.user.domain.Users;
import ru.fallindawn.booking.user.repository.UsersRepository;

@Slf4j
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) {
        var user = usersRepository.findByLogin(login);
        return createSpringSecurityUser(user);
    }

    private User createSpringSecurityUser(Users user) {
        var grantedAuthorities = user.getRoles().stream()
                .map(UserDetailService::newSimpleGrantedAuthorityInstance)
                .toList();
        return new User(user.getLogin(), user.getPassword(), grantedAuthorities);
    }

    private static SimpleGrantedAuthority newSimpleGrantedAuthorityInstance(Role role) {
        return new SimpleGrantedAuthority("");
    }
}
