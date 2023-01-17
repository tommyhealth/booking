package ru.fallindawn.booking.client.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fallindawn.booking.client.dto.ClientDto;
import ru.fallindawn.booking.utils.web.response.ErrorResponse;

@RequestMapping("/v1")
public interface ClientController {

    @PostMapping("/client")
    @Operation(
            summary = "Client registration",
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
    ClientDto registerClient(@RequestBody ClientDto clientDto);

}
