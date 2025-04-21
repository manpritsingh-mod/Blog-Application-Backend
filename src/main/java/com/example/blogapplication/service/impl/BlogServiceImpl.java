package com.example.blogapplication.service.impl;

import com.example.blogapplication.entity.Blog;
import com.example.blogapplication.entity.User;
import com.example.blogapplication.exception.BlogNotFoundException;
import com.example.blogapplication.exception.ResourceNotFoundException;
import com.example.blogapplication.exception.UserNotFoundException;
import com.example.blogapplication.repository.BlogRepository;
import com.example.blogapplication.repository.UserRepository;
import com.example.blogapplication.service.BlogService;
import com.example.blogapplication.util.BlogPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    public final BlogRepository blogRepository;
    public final UserRepository userRepository;

    @Override
    public Blog createBlog(Blog blog) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + email));
        blog.setUser(user);

        return blogRepository.save(blog);
    }

    @Override
    public Blog findBlogById(String id) {
        return blogRepository.findById(String.valueOf(UUID.fromString(id)))
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));
    }

    @Override
    public Blog updateBlogId(String blogId, Blog updatedBlog) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found"));

        blog.setTitle(updatedBlog.getTitle());
        blog.setContent(updatedBlog.getContent());
        blog.setUpdatedAt(LocalDateTime.now());

        return blogRepository.save(blog);
    }

    @Override
    public Blog deleteBlogById(String blogId) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found with id: " + blogId));
        blogRepository.delete(blog);
        return blog;
    }

    @Override
    public BlogPageResponse findAllBlogs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Blog> blogs = blogRepository.findAll(pageable);

        if (blogs.isEmpty()) {
            throw new BlogNotFoundException("No blogs found " + page);
        }

        return new BlogPageResponse(
                blogs.getNumber(),
                blogs.getSize(),
                blogs.getTotalPages(),
                blogs.getContent()
        );
    }

    @Override
    public BlogPageResponse findBlogsByCurrentUser(int page, int size) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Blog> blogPage = blogRepository.findAllByUserEmail(userEmail, pageable);

        BlogPageResponse response = new BlogPageResponse();
        response.setPage(blogPage.getNumber());
        response.setPageSize(blogPage.getSize());
        response.setTotalPages(blogPage.getTotalPages());
        response.setContent(blogPage.getContent());

        return response;
    }


}
