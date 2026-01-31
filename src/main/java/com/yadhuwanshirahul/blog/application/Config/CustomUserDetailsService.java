package com.yadhuwanshirahul.blog.application.Config;

import com.yadhuwanshirahul.blog.application.Model.CustomUserDetails;
import com.yadhuwanshirahul.blog.application.Model.User;
import com.yadhuwanshirahul.blog.application.Reposirtory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        try{
            user = userRepo.findByUsername(username);
        }
        catch(UsernameNotFoundException e){
            throw new UsernameNotFoundException("User not found with "+username);
        }
        CustomUserDetails userDetails = new CustomUserDetails(user);

        return userDetails;
    }
}
