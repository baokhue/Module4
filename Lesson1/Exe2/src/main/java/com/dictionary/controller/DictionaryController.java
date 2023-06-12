package com.dictionary.controller;

import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    public IDictionaryService dictionaryService;

    @GetMapping("/translate-form")
    public String showForm() {
        return "/dictionary";
    }

    @PostMapping("/translation")
    public String translate(@RequestParam String US, Model model) {
        model.addAttribute("US", US);
        model.addAttribute("VN", dictionaryService.translate(US));
        return "/dictionary";
    }
}
