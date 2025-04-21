package com.example.blogapplication.controller;

import com.example.blogapplication.entity.Blog;
import com.example.blogapplication.service.BlogService;
import com.example.blogapplication.util.BlogPageResponse;
import com.example.blogapplication.util.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class BlogController {

    public final BlogService blogService;

    @PostMapping("/blogs")
    public ResponseEntity<ResponseStructure<Blog>> insertBlog(@RequestBody Blog blog){
        Blog savedBlog = blogService.createBlog(blog);

        ResponseStructure<Blog> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setMessage("Blog created successfully");
        responseStructure.setData(savedBlog);

        return new ResponseEntity<ResponseStructure<Blog>>(responseStructure, HttpStatus.CREATED);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<ResponseStructure<Blog>> findBlogById(@PathVariable String id){
        Blog blog = blogService.findBlogById(id);
        ResponseStructure<Blog> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Blog found successfully");
        responseStructure.setData(blog);
        return new ResponseEntity<ResponseStructure<Blog>>(responseStructure, HttpStatus.OK);
    }

    @PutMapping("/blogs/{id}")
    public ResponseEntity<ResponseStructure<Blog>> updateBlogById(@PathVariable String id, @RequestBody Blog updatedBlog) {
        Blog blog = blogService.updateBlogId(id, updatedBlog);
        ResponseStructure<Blog> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Blog updated successfully");
        responseStructure.setData(blog);

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    @DeleteMapping( "/blogs/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteBlogById(@PathVariable String id) {
        blogService.deleteBlogById(id);
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Blog deleted successfully");
        responseStructure.setData("Deleted blog with id: " + id);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<ResponseStructure<BlogPageResponse>> getAllBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        BlogPageResponse blogPageResponse = blogService.findAllBlogs(page, size);

        ResponseStructure<BlogPageResponse> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Blogs fetched successfully along with pagination");
        responseStructure.setData(blogPageResponse);

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    @GetMapping("/myblogs")
    public ResponseEntity<ResponseStructure<BlogPageResponse>> getMyBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        BlogPageResponse myBlogs = blogService.findBlogsByCurrentUser(page, size);

        ResponseStructure<BlogPageResponse> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("User's blogs fetched successfully");
        responseStructure.setData(myBlogs);

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }





}
