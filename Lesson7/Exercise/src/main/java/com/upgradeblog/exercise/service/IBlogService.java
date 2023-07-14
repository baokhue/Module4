package com.upgradeblog.exercise.service;


import com.upgradeblog.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
//    Page<Blog> findAll(Pageable pageable);
    List<Blog> findAll();
    boolean write(Blog blog);
    Blog findById(int id);
    boolean delete(int id);
}
