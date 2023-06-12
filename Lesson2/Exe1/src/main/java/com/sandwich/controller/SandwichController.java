package com.sandwich.controller;

import com.sandwich.model.Sandwich;
import com.sandwich.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {
    @Autowired
    private ISandwichService sandwichService;

    @GetMapping("/")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Sandwich> sandwichList = sandwichService.findAll();
        modelAndView.addObject("sandwichList", sandwichList);
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public String showCondiments() {
        return "/add";
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@RequestParam int idBills, @RequestParam String condiments) {
        Sandwich sandwich = new Sandwich(idBills, condiments);
        sandwichService.save(sandwich);
        ModelAndView modelAndView  = new ModelAndView("/list");
        List<Sandwich> sandwichList = sandwichService.findAll();
        modelAndView.addObject("sandwichList", sandwichList);
        return modelAndView;
    }
}
