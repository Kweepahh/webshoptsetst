package org.example.zaalschoenenwebshop.dao;


import org.example.zaalschoenenwebshop.dto.CategoryDTO;
import org.example.zaalschoenenwebshop.models.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryDAO {
    private CategoryRepository categoryRepository;

    public CategoryDAO (CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getAllCategories(){
        return this.categoryRepository.findAll();
    }

    public void createCategory(CategoryDTO categoryDTO){
        Category category = new Category(categoryDTO.name);
        this.categoryRepository.save(category);
    }


}