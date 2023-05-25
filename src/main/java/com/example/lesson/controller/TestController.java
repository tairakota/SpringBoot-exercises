package com.example.lesson.controller;

import com.example.lesson.Service.ProductService;
import com.example.lesson.form.add.AddForm;
import com.example.lesson.form.update.UpdateForm;
import com.example.lesson.record.ProductRecord;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public String product(@PathVariable("id") int id) {
        var product = productService.findById(id);
        session.setAttribute("setId", id);
        session.setAttribute("pr", product);
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

    @GetMapping("/product/update/{id}")
    public String index(@PathVariable("id") int id, @ModelAttribute("updateForm") UpdateForm updateForm) {
        var product = productService.findById(id);
        session.setAttribute("updId", id);
        updateForm.setUpdateName(product.name());
        updateForm.setUpdatePrice(Integer.toString(product.price()));
        return "product-update";
    }

    @PostMapping("/product/update")
    public String update(@Validated @ModelAttribute("updateForm") UpdateForm updateForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "product-update";
        }
        var id = (Integer)session.getAttribute("updId");
        var product = new ProductRecord(id, updateForm.getUpdateName(), Integer.parseInt(updateForm.getUpdatePrice()));
        productService.update(product);

        List list = productService.findAll();
        session.setAttribute("products", list);
        return "product-list";
    }

    @GetMapping("/product-delete")
    public String delete() {
        System.out.println(session.getAttribute("setId"));
        productService.delete((int)session.getAttribute("setId"));

        List list = productService.findAll();
        session.setAttribute("products", list);
        return "product-list";
    }
}
