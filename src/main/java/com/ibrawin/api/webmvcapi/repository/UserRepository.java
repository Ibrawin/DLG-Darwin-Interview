package com.ibrawin.api.webmvcapi.repository;

import com.ibrawin.api.webmvcapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
