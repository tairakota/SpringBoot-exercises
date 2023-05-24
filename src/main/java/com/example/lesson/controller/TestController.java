package com.example.lesson.controller;

import com.example.lesson.Service.ProductService;
import com.example.lesson.form.add.AddForm;
import com.example.lesson.record.ProductRecord;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private ProductService productService;

    @Autowired
    private HttpSession session;

    @GetMapping("/index")
    @ResponseBody
    public String index() {
        return "Hello Spring";
    }

    @GetMapping("/product-list")
    public String productList() {
        List list = productService.findAll();
        session.setAttribute("products", list);
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
    public String add(@Validated @ModelAttribute("addForm") AddForm addForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "product-add";
        }
        var product = new ProductRecord(null, addForm.getAddName(), Integer.parseInt(addForm.getAddPrice()));
        productService.insert(product);

        List list = productService.findAll();
        session.setAttribute("products", list);
        return "product-list";
    }
}
