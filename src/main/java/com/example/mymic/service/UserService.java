package com.example.mymic.service;

import com.example.mymic.dto.user.UserResponseDto;
import com.example.mymic.entity.Post;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(UUID id);

    void deleteUser(UUID id);

    List<Post> getAllUserPosts(UUID id);

}
