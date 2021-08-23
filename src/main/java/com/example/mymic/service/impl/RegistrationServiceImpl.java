package com.example.mymic.service.impl;

import com.example.mymic.dto.user.RegistrationDto;
import com.example.mymic.entity.User;
import com.example.mymic.mapper.UserMapper;
import com.example.mymic.repository.UserRepository;
import com.example.mymic.service.RegistrationService;
import com.example.mymic.validator.RegistrationValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationValidator registrationValidator;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public void registerUser(RegistrationDto dto) {
        registrationValidator.validateRegistration(dto);

        User userToSave = userMapper.mapRegistrationDtoToEntity(dto);
        userRepository.save(userToSave);
        log.info("Registration completed successfully");
    }

}
