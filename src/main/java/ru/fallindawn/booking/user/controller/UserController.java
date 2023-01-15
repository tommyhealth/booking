package ru.fallindawn.booking.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.fallindawn.booking.security.jwt.JwtResponse;
import ru.fallindawn.booking.user.dto.UserSignInOrUpCommand;
import ru.fallindawn.booking.user.dto.UserDto;

import javax.validation.Valid;

@RequestMapping("/v1")
public interface UserController {

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    UserDto signUp(@RequestBody @Valid UserSignInOrUpCommand userSignInOrUpCommand);

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<JwtResponse> signIn(@RequestBody @Valid UserSignInOrUpCommand userSignInOrUpCommand);
}
