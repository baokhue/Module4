package com.sandwich.service;

import com.sandwich.model.Sandwich;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISandwichService {
    List<Sandwich> findAll();
    boolean save(Sandwich sandwich);
}
