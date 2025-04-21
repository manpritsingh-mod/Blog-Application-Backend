package com.example.blogapplication.util;


import com.example.blogapplication.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPageResponse {

    private int page;
    private int pageSize;
    private int totalPages;
    private List<Blog> content;
}
