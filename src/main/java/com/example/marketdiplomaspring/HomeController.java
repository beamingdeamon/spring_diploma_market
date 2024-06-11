package com.example.marketdiplomaspring;

import com.example.marketdiplomaspring.Category.CategoryRepository;
import com.example.marketdiplomaspring.OrderProducts.OrderProductRepository;
import com.example.marketdiplomaspring.Orders.OrderRepository;
import com.example.marketdiplomaspring.Product.Product;
import com.example.marketdiplomaspring.Product.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController{
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    public HomeController(CategoryRepository categoryRepository, ProductRepository productRepository, OrderRepository orderRepository, OrderProductRepository orderProductRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
    }
    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @RequestMapping("/category/{id}")
    public String getCategory(Model model, @PathVariable Long id) {
        model.addAttribute("categories", categoryRepository.findAll());

        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("category_id", id);
        model.addAttribute("category_name", categoryRepository.findById(id).get().getName());
        return "category";
    }

    @RequestMapping("/cart")
    public String goCart(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "cart";
    }

    @RequestMapping("/admin")
    public String goToAdmin(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("orders", orderRepository.findAll());
        model.addAttribute("order_products", orderProductRepository.findAll());
        return "admin";
    }
}