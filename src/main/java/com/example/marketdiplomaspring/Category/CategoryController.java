package com.example.marketdiplomaspring.Category;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;


    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @GetMapping("")
    public Iterable<Category> getCategories()
    {
        CategoryService categoryService = new CategoryService();

        return categoryService.getCategories(this.categoryRepository);
    }

    @PostMapping("")
    public Category addCategory(@RequestBody Category category) {

        CategoryService categoryService = new CategoryService();

        return categoryService.addCategory(this.categoryRepository, category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category category,  @PathVariable Long id) {

        CategoryService categoryService = new CategoryService();

        return categoryService.updateCategory(this.categoryRepository,category, id);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {

        CategoryService categoryService = new CategoryService();

        String response = categoryService.deleteCategory(this.categoryRepository, id);

        return response;
    }
}