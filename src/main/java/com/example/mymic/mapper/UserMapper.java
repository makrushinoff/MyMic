package com.example.mymic.mapper;

import com.example.mymic.dto.user.RegistrationDto;
import com.example.mymic.dto.user.UserResponseDto;
import com.example.mymic.entity.Role;
import com.example.mymic.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public User mapRegistrationDtoToEntity(RegistrationDto dto) {
        User user = new User();
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUsername(dto.getUsername());
        user.setBirthDate(dto.getBirthDate());
        user.setRole(Role.USER);
        user.setEnabled(true);

        return user;
    }

    public UserResponseDto mapEntityToResponseDto(User entity) {
        UserResponseDto dto = new UserResponseDto();

        dto.setBirthDate(entity.getBirthDate());
        dto.setEmail(entity.getEmail());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setUsername(entity.getUsername());

        return dto;
    }

    public List<UserResponseDto> mapEntityListToResponseDtoList(List<User> entities) {
        List<UserResponseDto> dtoList = new ArrayList<>();
        entities.forEach(entity -> dtoList.add(mapEntityToResponseDto(entity)));
        return dtoList;
    }

}
