package com.blog.exercise.controller;

import com.blog.exercise.model.Blog;
import com.blog.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        model.addAttribute("blog", new Blog());
        return "/list";
    }

    @GetMapping(value = "/create")
    public String showFormAdd(Model model){
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @GetMapping(value = "/edit/{id}")
    public String showFormEdit(Model model, @PathVariable int id){
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }

    @GetMapping("/detail/{id}")
    public String showDetail2(@PathVariable int id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "/detail";
    }

    //    @GetMapping("/delete/{id}")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        blogService.delete(id);
        return "redirect:/blog";
    }

    @PostMapping("/create")
    public ModelAndView save(@ModelAttribute Blog blog){
        blogService.write(blog);
        ModelAndView modelAndView = new ModelAndView("list");
        List<Blog> blogs = blogService.findAll();
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Blog blog){
        blogService.write(blog);
        ModelAndView modelAndView = new ModelAndView("list");
        List<Blog> blogs = blogService.findAll();
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }

}
