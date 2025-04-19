package com.example.blogapplication.service.impl;

import com.example.blogapplication.entity.User;
import com.example.blogapplication.repository.UserRepository;
import com.example.blogapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user){
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists with this email");
        }else {
            return userRepository.save(user);
        }
    }
}
