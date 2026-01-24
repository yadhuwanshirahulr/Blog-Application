package com.yadhuwanshirahul.blog.application.Reposirtory;

import com.yadhuwanshirahul.blog.application.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
