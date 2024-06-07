package com.example.marketdiplomaspring.Category;

public class CategoryService {

    public Iterable<Category> getCategories(CategoryRepository categoryRepository) {
        return categoryRepository.findAll();
    }

    public Category addCategory(CategoryRepository categoryRepository, Category category) {

        return categoryRepository.save(category);
    }

    public Category updateCategory(CategoryRepository categoryRepository, Category new_category, Long id) {

        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(new_category.getName());
                    return categoryRepository.save(category);
                })
                .orElseGet(() -> {
                    new_category.setId(id);
                    return categoryRepository.save(new_category);
                });
    }

    public String deleteCategory(CategoryRepository categoryRepository, Long id) {
        Object finded_category = categoryRepository.findById(id);
        if (finded_category != null) {
            categoryRepository.deleteById(id);
            return "Category deleted";
        }else {
            return "Category not found";
        }



    }
}
