package com.example.mymic.service;

import com.example.mymic.entity.Post;
import com.example.mymic.entity.User;

import java.util.List;
import java.util.UUID;

public interface PostService {

    List<Post> getAllPosts();

    Post getPostById(UUID id);

    Post savePost(Post post);

    Post updatePost(UUID id, Post postRepository);

    void deletePost(UUID id);

    User getUserByPostId(UUID postId);

}
