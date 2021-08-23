package com.example.mymic.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class RegistrationDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String username;

    @NotNull(message = "Password can not be null")
    @Size(min = 8)
    private String password;

}
