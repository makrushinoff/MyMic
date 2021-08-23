package com.example.mymic.dto.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDto {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String username;

}
