package com.calculator.controller;

import com.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("/calculator")
    public String showCalculator(){
        return "/calculator";
    }

    @PostMapping("/result")
    public String calculate(@RequestParam float firstNumber,
                            @RequestParam float secondNumber,
                            @RequestParam char operator,
                            Model model) {
        float result = calculatorService.calculate(firstNumber, secondNumber, operator);
        model.addAttribute("result", result);
        return "/calculator";
    }
}
