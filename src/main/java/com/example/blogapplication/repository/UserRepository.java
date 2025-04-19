package com.example.blogapplication.repository;

import com.example.blogapplication.entity.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Registered
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
