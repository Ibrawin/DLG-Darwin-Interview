package com.ibrawin.api.webmvcapi.service;

import com.ibrawin.api.webmvcapi.model.User;
import com.ibrawin.api.webmvcapi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserById(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User deleteUserById(long id) {
        return null;
    }
}
