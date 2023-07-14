package com.upgradeblog.exercise.service;

import com.upgradeblog.exercise.model.Blog;
import com.upgradeblog.exercise.repository.IBlogRepository;
import com.upgradeblog.exercise.model.Blog;
import com.upgradeblog.exercise.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

//    @Override
//    public Page<Blog> findAll(Pageable pageable) {
//        return blogRepository.findAll(pageable);
//    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public boolean write(Blog blog) {
        Blog blog1 = blogRepository.save(blog);
        return blog1 != null;
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(int id) {
        blogRepository.deleteById(id);
        return true;
    }
}
