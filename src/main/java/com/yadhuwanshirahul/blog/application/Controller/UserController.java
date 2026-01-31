package com.yadhuwanshirahul.blog.application.Controller;

import com.yadhuwanshirahul.blog.application.PayLoad.UserDto;
import com.yadhuwanshirahul.blog.application.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto user){
        UserDto response =  userService.addUser(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUser();
    }
    @PutMapping("{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto user, @PathVariable Integer userId){
        UserDto response = userService.updateUser(user,userId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> removeUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return  new ResponseEntity("User Removed",HttpStatus.OK);
    }

}
