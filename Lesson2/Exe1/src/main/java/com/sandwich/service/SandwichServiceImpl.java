package com.sandwich.service;

import com.sandwich.model.Sandwich;
import com.sandwich.service.ISandwichService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SandwichServiceImpl implements ISandwichService {
    private static List<Sandwich> sandwichList = new ArrayList<>();

    static {
        sandwichList.add(new Sandwich(1, "Lettuce, Mustard, Sprouts"));
        sandwichList.add(new Sandwich(2, "Lettuce, Mustard"));
        sandwichList.add(new Sandwich(3, "Lettuce, Sprouts"));
    }

    @Override
    public List<Sandwich> findAll() {
        return sandwichList;
    }

    @Override
    public boolean save(Sandwich sandwich) {
        return false;
    }
}
