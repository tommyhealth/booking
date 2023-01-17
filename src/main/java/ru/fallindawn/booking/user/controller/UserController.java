package ru.fallindawn.booking.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.fallindawn.booking.security.jwt.JwtResponse;
import ru.fallindawn.booking.user.dto.UserDto;
import ru.fallindawn.booking.user.dto.UserSignInOrUpCommand;
import ru.fallindawn.booking.utils.web.response.ErrorResponse;

import javax.validation.Valid;

@RequestMapping("/v1")
public interface UserController {

    @PostMapping("/auth:signup")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "User creating by login and password",
            security = {@SecurityRequirement(name = "Bearer Authentication")},
            responses = {
                    @ApiResponse(responseCode = "201"),
                    @ApiResponse(
                            responseCode = "404",
                            content = {@Content(schema = @Schema(implementation = ErrorResponse.class))}
                    ),

                    @ApiResponse(
                            responseCode = "500",
                            content = {@Content(schema = @Schema(implementation = ErrorResponse.class))}
                    )
            }
    )
    UserDto signUp(@RequestBody @Valid UserSignInOrUpCommand userSignInOrUpCommand);

    @PostMapping("/auth:signin")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "User sign in by login and password",
            security = {@SecurityRequirement(name = "Bearer Authentication")},
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(
                            responseCode = "404",
                            content = {@Content(schema = @Schema(implementation = ErrorResponse.class))}
                    ),

                    @ApiResponse(
                            responseCode = "500",
                            content = {@Content(schema = @Schema(implementation = ErrorResponse.class))}
                    )
            }
    )
    ResponseEntity<JwtResponse> signIn(@RequestBody @Valid UserSignInOrUpCommand userSignInOrUpCommand);
}
