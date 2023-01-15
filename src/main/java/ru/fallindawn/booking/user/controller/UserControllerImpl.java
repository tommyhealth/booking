package ru.fallindawn.booking.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import ru.fallindawn.booking.security.jwt.JwtResponse;
import ru.fallindawn.booking.security.jwt.JwtService;
import ru.fallindawn.booking.user.dto.UserDto;
import ru.fallindawn.booking.user.dto.UserSignInOrUpCommand;
import ru.fallindawn.booking.user.service.UserService;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @Override
    public UserDto signUp(UserSignInOrUpCommand userSignInOrUpCommand) {
        return userService.create(userSignInOrUpCommand);
    }

    @Override
    public ResponseEntity<JwtResponse> signIn(UserSignInOrUpCommand userSignInOrUpCommand) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(
                userSignInOrUpCommand.getLogin(),
                userSignInOrUpCommand.getPassword()
        );
        var authentication = authenticationManagerBuilder
                .getObject()
                .authenticate(authenticationToken);

        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);

        var jwt = jwtService.generateJwtToken(authentication);
        var httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer $jwt");
        return new ResponseEntity<>(new JwtResponse(jwt), httpHeaders, HttpStatus.OK);
    }
}
