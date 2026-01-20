package com.yadhuwanshirahul.blog.application.Reposirtory;

import com.yadhuwanshirahul.blog.application.Model.Category;
import com.yadhuwanshirahul.blog.application.Model.Post;
import com.yadhuwanshirahul.blog.application.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByCategory(Category category);
    List<Post> findByUser(User user);

    //Using JPA trick for searching
    List<Post> findByTitleContaining(String title);

    //using Query to search
//    @Query("select * from posts p where where p.title like :key")
//    List<Post> findPostContainingTitle(@Param("key") String title);
}
