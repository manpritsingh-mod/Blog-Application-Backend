package com.example.blogapplication.service;

import com.example.blogapplication.entity.Blog;
import com.example.blogapplication.util.BlogPageResponse;

public interface BlogService {
    Blog createBlog(Blog blog);

    Blog findBlogById(String id);

    Blog updateBlogId(String id, Blog blog);

    Blog deleteBlogById(String id);

    BlogPageResponse findAllBlogs(int page, int size);

    BlogPageResponse findBlogsByCurrentUser(int page, int size);



}
