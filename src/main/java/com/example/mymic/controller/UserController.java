package com.example.mymic.controller;

import com.example.mymic.dto.user.RegistrationDto;
import com.example.mymic.dto.user.UserResponseDto;
import com.example.mymic.service.RegistrationService;
import com.example.mymic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RegistrationService registrationService;

    @PostMapping("/registration")
    public void registerUser(@RequestBody RegistrationDto dto) {
        registrationService.registerUser(dto);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('Users.Manage')")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('Users.Read')")
    public UserResponseDto getUser(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('Users.Manage')")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }

}
