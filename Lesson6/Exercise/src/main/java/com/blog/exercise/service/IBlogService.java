package com.blog.exercise.service;


import com.blog.exercise.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    boolean write(Blog blog);
    Blog findById(int id);
    boolean delete(int id);
}
