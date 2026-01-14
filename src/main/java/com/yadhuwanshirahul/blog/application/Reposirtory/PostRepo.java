package com.yadhuwanshirahul.blog.application.Reposirtory;

import com.yadhuwanshirahul.blog.application.Model.Category;
import com.yadhuwanshirahul.blog.application.Model.Post;
import com.yadhuwanshirahul.blog.application.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByCategory(Category category);
    List<Post> findByUser(User user);
}
