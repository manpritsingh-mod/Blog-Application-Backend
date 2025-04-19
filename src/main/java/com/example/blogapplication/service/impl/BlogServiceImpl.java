package com.example.blogapplication.service.impl;

import com.example.blogapplication.entity.Blog;
import com.example.blogapplication.entity.User;
import com.example.blogapplication.exception.UserNotFoundException;
import com.example.blogapplication.repository.BlogRepository;
import com.example.blogapplication.repository.UserRepository;
import com.example.blogapplication.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    public final BlogRepository blogRepository;
    public final UserRepository userRepository;

    @Override
    public Blog createBlog(String userId, Blog blogRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Blog blog = new Blog();
        blog.setTitle(blogRequest.getTitle());
        blog.setBlogStatus(blogRequest.getBlogStatus());
        blog.setCreatedAt(blogRequest.getCreatedAt());
        blog.setUpdatedAt(blogRequest.getUpdatedAt());
        blog.setUser(user);

        return blogRepository.save(blog);
    }
}
