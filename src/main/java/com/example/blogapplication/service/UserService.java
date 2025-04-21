package com.example.blogapplication.service;


import com.example.blogapplication.entity.User;

public interface UserService {

    User registerUser(User user);

    User getUserByEmail(String email);


}
