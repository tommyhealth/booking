package ru.fallindawn.booking.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fallindawn.booking.user.dto.UserSignInOrUpCommand;
import ru.fallindawn.booking.user.dto.UserDto;
import ru.fallindawn.booking.user.exception.UserExistsException;
import ru.fallindawn.booking.user.mapper.UsersMapper;
import ru.fallindawn.booking.user.repository.UsersRepository;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsersMapper usersMapper;

    @Transactional
    public UserDto create(UserSignInOrUpCommand userSignInOrUpCommand) {
        log.info("Enter create(). User: {}", userSignInOrUpCommand);
        var login = userSignInOrUpCommand.getLogin();
        var password = passwordEncoder.encode(userSignInOrUpCommand.getPassword());
        userSignInOrUpCommand.setPassword(password);
        if (usersRepository.existsByLogin(login)) {
            throw new UserExistsException("User %s already exists".formatted(login));
        } else {
            var result = usersRepository.save(usersMapper.toEntity(userSignInOrUpCommand));
            var createdUserDto = usersMapper.toDto(result);
            log.info("Exit: create(). Created user: {}", createdUserDto);
            return createdUserDto;
        }
    }

}
