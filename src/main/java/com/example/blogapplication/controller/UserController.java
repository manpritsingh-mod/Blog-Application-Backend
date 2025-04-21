package com.example.blogapplication.controller;

import com.example.blogapplication.entity.User;
import com.example.blogapplication.service.UserService;
import com.example.blogapplication.util.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user) {
       User user1 =  userService.registerUser(user);

        ResponseStructure<User> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setMessage("User created successfully");
        responseStructure.setData(user1);

        return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);

    }

    @GetMapping("/account")
    public ResponseEntity<ResponseStructure<User>> getUserByEmail() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByEmail(email);

        ResponseStructure<User> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("User fetched successfully");
        response.setData(user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }





}
