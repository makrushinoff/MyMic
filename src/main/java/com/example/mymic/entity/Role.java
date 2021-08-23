package com.example.mymic.entity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER("User" , Set.of(Permission.POSTS_READ, Permission.POSTS_CREATE, Permission.POSTS_DELETE, Permission.USERS_READ)),

    ADMIN("Admin", Set.of(Permission.POSTS_CREATE,
                                Permission.POSTS_DELETE_ALL,
                                Permission.USERS_MANAGE, Permission.POSTS_READ,
                                Permission.POSTS_DELETE,  Permission.USERS_READ));

    private final String roleName;
    private final Set<Permission> permissions;


    Role(String roleName, Set<Permission> permissions) {
        this.roleName = roleName;
        this.permissions = permissions;
    }

    public String getRoleName() {
        return roleName;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toSet());
    }
}
