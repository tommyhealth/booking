package ru.fallindawn.booking.reservation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fallindawn.booking.reservation.dto.ReservationDto;
import ru.fallindawn.booking.utils.web.response.ErrorResponse;

@RequestMapping("/v1")
public interface ReservationController {

    @PostMapping("/reservation")
    @Operation(
            summary = "Reserve room by client and check in check out dates",
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
    ReservationDto makeReserve(@RequestBody ReservationDto makeReserveDto);
}
