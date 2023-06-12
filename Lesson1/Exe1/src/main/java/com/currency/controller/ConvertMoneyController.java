package com.currency.controller;

import com.currency.service.IConvertMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ConvertMoneyController {
    @Autowired
    private IConvertMoneyService convertMoneyService;

    @GetMapping("/converting-form")
    public String showForm(){
        return "convertMoney";
    }

    @PostMapping("/convert-money")
    public String convertMoney(@RequestParam double USD, Model model){
        model.addAttribute("total", convertMoneyService.convertMoney(USD));
        model.addAttribute("USD", USD);
        return "convertMoney";
    }
}
