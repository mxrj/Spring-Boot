package com.example.laba11111.repository;

import com.example.laba11111.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByLogin(String login);
}
