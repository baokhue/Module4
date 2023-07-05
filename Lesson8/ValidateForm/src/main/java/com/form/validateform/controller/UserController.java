package com.form.validateform.controller;

import com.form.validateform.dto.UserDto;
import com.form.validateform.model.User;
import com.form.validateform.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/validate")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("")
    public String showPage(@RequestParam(defaultValue = "0") int page , ModelMap model) {
        Pageable pageable = PageRequest.of(page,10);
        Page<User> userPages = userService.findAll(pageable);
        model.addAttribute("userPages", userPages);
        return "/list";
    }

    @GetMapping("/sign_up")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/form";
    }

    @PostMapping("/sign_up")
    public String add(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "/form";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.add(user);
        redirectAttributes.addFlashAttribute("mess", "Sign up successful!");
        return "redirect:/validate";
    }
}
