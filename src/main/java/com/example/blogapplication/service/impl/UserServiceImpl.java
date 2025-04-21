package com.example.blogapplication.service.impl;

import com.example.blogapplication.entity.User;
import com.example.blogapplication.exception.UserExistException;
import com.example.blogapplication.exception.UserNotFoundException;
import com.example.blogapplication.repository.UserRepository;
import com.example.blogapplication.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Override
    public User registerUser(User user){
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserExistException("User already exists with this email");
        }else {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            return userRepository.save(user);
        }
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: "));
    }


}
