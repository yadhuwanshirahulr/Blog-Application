package com.yadhuwanshirahul.blog.application.Reposirtory;

import com.yadhuwanshirahul.blog.application.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
