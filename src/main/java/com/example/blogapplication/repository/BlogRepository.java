package com.example.blogapplication.repository;

import com.example.blogapplication.entity.Blog;
import com.example.blogapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog,String> {
    List<Blog> findByUserId(String id);

}
