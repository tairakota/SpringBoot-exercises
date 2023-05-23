package com.example.lesson.controller;

import com.example.lesson.LessonApplication;
import com.example.lesson.Service.PgProductService;
import com.example.lesson.Service.ProductService;
import com.example.lesson.form.add.AddForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    @ResponseBody
    public String index() {
        return "Hello Spring";
    }

    @GetMapping("/product-list")
    public String productList(Model model) {
        List list = productService.findAll();
        model.addAttribute("products", list);
        return "product-list";
    }

    @GetMapping("/product/{id}")
    public String product(Model model, @PathVariable("id") int id) {
        var product = productService.findById(id);
        model.addAttribute("pr", product);
        return "product";
    }

    @GetMapping("/product-add")
    public String index(@ModelAttribute("addForm") AddForm addForm) {
        return "product-add";
    }

    @PostMapping("/product-add")
    public String login(@ModelAttribute("addForm") AddForm addForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "login";
        }
        return "/product-list";
    }
}
