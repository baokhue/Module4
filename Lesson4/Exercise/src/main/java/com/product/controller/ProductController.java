package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping(value = "/")
    public String showList (ModelMap model) {
        List<Product> products = productService.showList();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping(value = "/create")
    public String showFormAdd(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        productService.remove(id);
        List<Product> products = productService.showList();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping ("/update/{id}")
    public String showFormUpdate(Model model,@PathVariable int id) {
        model.addAttribute("product", productService.findById(id));
        return "/update";
    }

    @PostMapping("/create")
    public ModelAndView save(@ModelAttribute Product product){
        productService.add(product);
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> products = productService.showList();
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @PostMapping ("/update")
    public ModelAndView update(@ModelAttribute Product product) {
        productService.update(product);
        ModelAndView modelAndView = new ModelAndView("list");
        List<Product> products = productService.showList();
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}
