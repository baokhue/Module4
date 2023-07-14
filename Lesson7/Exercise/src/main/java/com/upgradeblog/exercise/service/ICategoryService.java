package com.upgradeblog.exercise.service;

import com.upgradeblog.exercise.model.Blog;
import com.upgradeblog.exercise.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> showList();
    boolean add(Category category);
    boolean delete(int id);
}
