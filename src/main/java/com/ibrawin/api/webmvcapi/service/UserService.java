package com.ibrawin.api.webmvcapi.service;

import com.ibrawin.api.webmvcapi.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(int id);

    List<User> findAllUsers();

    User saveUser(User user);

    void deleteUserById(int id);
}
