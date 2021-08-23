package com.example.mymic.validator;

import com.example.mymic.dto.user.RegistrationDto;
import com.example.mymic.entity.User;
import com.example.mymic.exception.InvalidRegistrationException;
import com.example.mymic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RegistrationValidator {

    private final UserRepository userRepository;

    public void validateRegistration(RegistrationDto dto) {
        validateBirthDate(dto.getBirthDate());
        validateEmail(dto.getEmail());
        validateUsername(dto.getUsername());
    }

    private void validateUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalUser.isPresent()) {
            throw new InvalidRegistrationException("User with such username is already exits");
        }
    }

    private void validateEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()) {
            throw new InvalidRegistrationException("User with such email is already exists");
        }
    }

    private void validateBirthDate(LocalDate birthDate) {
        if(birthDate.isAfter(LocalDate.now())) {
            throw new InvalidRegistrationException("Birth date can not be a future date");
        }
    }

}
