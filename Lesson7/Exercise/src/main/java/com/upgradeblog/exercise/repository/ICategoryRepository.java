package com.upgradeblog.exercise.repository;

import com.upgradeblog.exercise.model.Blog;
import com.upgradeblog.exercise.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
