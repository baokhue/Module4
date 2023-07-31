package com.cart.cart.controller;

import com.cart.cart.dto.CartDto;
import com.cart.cart.dto.ProductDto;
import com.cart.cart.model.Product;
import com.cart.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCart(){
        System.out.println("cart------------------------");
        return new CartDto();
    }

    @GetMapping("")
    public String showPage(@RequestParam(defaultValue = "0") int page ,
                           ModelMap model) {
        Pageable pageable = PageRequest.of(page,12);
        Page<Product> productPages = productService.findAll(pageable);
        model.addAttribute("productPages", productPages);
        return "/shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute(value = "cart")CartDto cart, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        if (product!=null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/shop";
    }

//    @GetMapping("/delete/{id}")
//    public String deleteToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
//        Optional<Product> productOptional = productService.findById(id);
//        if (!productOptional.isPresent()) {
//            return "/error.404";
//        }
//        if (action.equals("show")) {
//            cart.deleteProduct(productOptional.get());
//            return "redirect:/shopping-cart";
//        }
//        cart.addProduct(productOptional.get());
//        return "redirect:/shop";
//    }



    @GetMapping("/shop/detail")
    public String showDetail(@RequestParam long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/detail";
    }



//    /*Hiện sản phẩm xem gần nhất*/
//    @GetMapping("/detail/{id}")
//    public ModelAndView showDetail(@PathVariable long id, HttpServletResponse response) {
//        Cookie cookie = new Cookie("productId",id+"");
//        cookie.setMaxAge(1*24*60*60);
//        cookie.setPath("/");
//        response.addCookie(cookie);
//        ModelAndView modelAndView = new ModelAndView("/shop");
//        modelAndView.addObject("products", productService.findAll());
//        return new ModelAndView("detail",
//                "product", productService.findById(id));
//    }
}
