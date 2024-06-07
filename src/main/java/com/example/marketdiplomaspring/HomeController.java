package com.example.marketdiplomaspring;

import com.example.marketdiplomaspring.Category.CategoryRepository;
import com.example.marketdiplomaspring.Category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
    private final CategoryRepository categoryRepository;

    public HomeController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @RequestMapping("/category/{id}")
    public String getCategory(@PathVariable Long id) {
        return "category";
    }
}