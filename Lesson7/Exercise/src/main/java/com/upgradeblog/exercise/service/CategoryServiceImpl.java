package com.upgradeblog.exercise.service;

import com.upgradeblog.exercise.model.Blog;
import com.upgradeblog.exercise.model.Category;
import com.upgradeblog.exercise.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> showList() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean add(Category category) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
