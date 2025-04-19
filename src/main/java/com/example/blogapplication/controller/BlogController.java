package com.example.blogapplication.controller;

import com.example.blogapplication.entity.Blog;
import com.example.blogapplication.service.BlogService;
import com.example.blogapplication.util.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blogs")
@RequiredArgsConstructor
public class BlogController {

    public final BlogService blogService;

    @PostMapping("/createBlog/{id}")
    public ResponseEntity<ResponseStructure<Blog>> insertBlog(@PathVariable String id, @RequestBody Blog blog){
        Blog savedBlog = blogService.createBlog(id, blog);

        ResponseStructure<Blog> responseStructure = new ResponseStructure<Blog>();
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setMessage("Blog created successfully");
        responseStructure.setData(savedBlog);
        return new ResponseEntity<ResponseStructure<Blog>>(responseStructure, HttpStatus.CREATED);
    }


}
