package ru.fallindawn.booking.user.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserSignInOrUpCommand {

    @NotNull
    @Size(max = 20)
    private String login;

    @NotNull
    @Size(min = 8, max = 32)
    private String password;
}
