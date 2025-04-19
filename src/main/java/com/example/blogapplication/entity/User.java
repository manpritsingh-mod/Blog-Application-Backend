package com.example.blogapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String email;
    private String name;
    private String password;

    @OneToMany
    private List<Blog> blogs = new ArrayList<>();


}
