package com.example.mymic.entity;

public enum Permission {
    POSTS_READ("Posts.Read"),
    POSTS_CREATE("Posts.Create"),
    POSTS_DELETE_ALL("Posts.DeleteAll"),
    POSTS_DELETE("Posts.Delete"),

    USERS_MANAGE("Users.Manage"),
    USERS_READ("Users.Read");

    private final String name;

    Permission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
