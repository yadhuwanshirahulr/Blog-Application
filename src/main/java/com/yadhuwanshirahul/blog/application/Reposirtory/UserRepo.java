package com.yadhuwanshirahul.blog.application.Reposirtory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yadhuwanshirahul.blog.application.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

    User findByUsername(String username);

}
