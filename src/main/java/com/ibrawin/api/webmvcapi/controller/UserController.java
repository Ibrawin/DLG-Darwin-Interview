package com.ibrawin.api.webmvcapi.controller;

import com.ibrawin.api.webmvcapi.model.User;
import com.ibrawin.api.webmvcapi.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserController {

    public static final String BASE_URL = "/api/users";


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> getAllUsers() {
        return null;
    }

    public Optional<User> getUserById() {
        return null;
    }

    public User newUser() {
        return null;
    }

    public void removeUser() {

    }
}
