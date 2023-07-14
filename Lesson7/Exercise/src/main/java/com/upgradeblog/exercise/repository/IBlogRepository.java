package com.upgradeblog.exercise.repository;

import com.upgradeblog.exercise.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
