package com.ibrawin.api.webmvcapi.controller;

import com.ibrawin.api.webmvcapi.model.User;
import com.ibrawin.api.webmvcapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User newUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }
}
