package com.email.controller;

import com.email.model.EmailConfiguration;
import com.email.service.IEmailConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/home")
public class EmailConfigurationController {

    @ModelAttribute("languages")
    public String[] getLanguages(){
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("pageSize")
    public int[] getPageSize(){
        return new int[]{ 5, 10, 15, 25, 50, 100};
    }

    @Autowired
    private IEmailConfigurationService emailConfigurationService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("list", emailConfigurationService.display());
        return "/list";
    }

    @GetMapping("/update")
    public String showUpdate(Model model, @RequestParam int id){
        EmailConfiguration emailConfiguration = emailConfigurationService.findById(id);
        model.addAttribute("emailConfiguration", emailConfiguration);
        return "/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute EmailConfiguration emailConfiguration, Model model) throws Exception {
        emailConfigurationService.update(emailConfiguration);
        model.addAttribute("list", emailConfigurationService.display());
        return "/list";
    }
}
