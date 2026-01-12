package com.yadhuwanshirahul.blog.application.Service.impl;

import com.yadhuwanshirahul.blog.application.Exception.ResourceNotFoundException;
import com.yadhuwanshirahul.blog.application.Model.Category;
import com.yadhuwanshirahul.blog.application.PayLoad.CategoryDTO;
import com.yadhuwanshirahul.blog.application.Reposirtory.CategoryRepo;
import com.yadhuwanshirahul.blog.application.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public CategoryDTO addCategory(CategoryDTO newCategory) {
        Category category = mapToCategory(newCategory);
        categoryRepo.save(category);
        return newCategory;
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDTO> response = new ArrayList<>();
        for(Category c:categories){
            CategoryDTO temp = mapToCategoryDto(c);
            response.add(temp);
        }
        return response;
    }

    private CategoryDTO mapToCategoryDto(Category c) {
        CategoryDTO categoryDTO = modelMapper.map(c,CategoryDTO.class);
        return categoryDTO;
    }

    @Override
    @Transactional
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException(
                "categoryId",
                "id",
                String.valueOf(categoryId)
        ));
        category.setCategoryDescription(categoryDTO.getCategoryDescription());
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        return categoryDTO;
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        categoryRepo.deleteById(categoryId);
    }

    @Override
    public CategoryDTO getCategoryById(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException(
                "Category",
                "categoryId",
                String.valueOf(categoryId)
        ));
        return mapToCategoryDto(category);
    }

    private Category mapToCategory(CategoryDTO categoryDTO){
        Category category = modelMapper.map(categoryDTO,Category.class);
        return category;
    }
}
