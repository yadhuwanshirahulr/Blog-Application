package com.yadhuwanshirahul.blog.application.Service;

import com.yadhuwanshirahul.blog.application.PayLoad.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO addCategory(CategoryDTO newCategory);
    List<CategoryDTO> getAllCategory();
    CategoryDTO updateCategory(CategoryDTO categoryDTO,Integer categoryId);
    void deleteCategory(Integer categoryId);
    CategoryDTO getCategoryById(Integer categoryId);
}
