package com.example.mymic.service.impl;

import com.example.mymic.dto.user.UserResponseDto;
import com.example.mymic.entity.Post;
import com.example.mymic.entity.User;
import com.example.mymic.exception.NotFoundException;
import com.example.mymic.mapper.UserMapper;
import com.example.mymic.repository.PostRepository;
import com.example.mymic.repository.UserRepository;
import com.example.mymic.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return userMapper.mapEntityListToResponseDtoList(allUsers);
    }

    @Override
    public UserResponseDto getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can not find user by this id"));
        return userMapper.mapEntityToResponseDto(user);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
        log.info("Deleted user with id: {}", id);
    }

    @Override
    public List<Post> getAllUserPosts(UUID id) {
        return postRepository.findAllByUserId(id);
    }
}
