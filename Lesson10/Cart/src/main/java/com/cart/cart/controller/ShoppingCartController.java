package com.cart.cart.controller;

import com.cart.cart.dto.CartDto;
import com.cart.cart.dto.ProductDto;
import com.cart.cart.model.Product;
import com.cart.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(value = "cart", required = false) CartDto cart){
        return new ModelAndView("/cart", "cart", cart);
    }

    @GetMapping("/addProduct/{id}")
    public String addToCart(@PathVariable long id, @SessionAttribute(value = "cart")CartDto cart, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        cart.increase(productDto);
        return "redirect:/shopping-cart";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteToCart(@PathVariable long id, @SessionAttribute(value = "cart")CartDto cart, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        if (product!=null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cart.decrease(productDto);
        }
        return "redirect:/shopping-cart";
    }
}
