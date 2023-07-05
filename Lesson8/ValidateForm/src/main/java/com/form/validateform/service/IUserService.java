package com.form.validateform.service;

import com.form.validateform.model.User;
import com.form.validateform.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAll(Pageable pageable);
    boolean add(User user);
}
