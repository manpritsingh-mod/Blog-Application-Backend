package com.example.blogapplication.dto;


import com.example.blogapplication.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
public class BlogPageResponse {

    private int page;
    private int pageSize;
    private List<Blog> content;



}
