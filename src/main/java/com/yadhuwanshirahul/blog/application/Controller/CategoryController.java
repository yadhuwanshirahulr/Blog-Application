package com.yadhuwanshirahul.blog.application.Controller;

import com.yadhuwanshirahul.blog.application.PayLoad.CategoryDTO;
import com.yadhuwanshirahul.blog.application.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<CategoryDTO> response = categoryService.getAllCategory();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CategoryDTO> addNewCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO response = categoryService.addCategory(categoryDTO);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO,@PathVariable Integer categoryId){
        CategoryDTO response = categoryService.updateCategory(categoryDTO,categoryId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(String.format("Category with %s Deleted",categoryId),HttpStatus.OK);
    }
    @GetMapping("{categoryId}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Integer categoryId){
        CategoryDTO response = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
}
