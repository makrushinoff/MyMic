package com.example.mymic.service.impl;

import com.example.mymic.entity.Post;
import com.example.mymic.entity.User;
import com.example.mymic.exception.NotFoundException;
import com.example.mymic.repository.PostRepository;
import com.example.mymic.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(UUID id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can not find post with such id"));
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(UUID id, Post user) {
        return null;
    }

    @Override
    public void deletePost(UUID id) {

    }

    @Override
    public User getUserByPostId(UUID postId) {
        return null;
    }
}
