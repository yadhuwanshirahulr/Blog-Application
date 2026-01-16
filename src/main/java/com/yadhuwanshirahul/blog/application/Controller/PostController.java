package com.yadhuwanshirahul.blog.application.Controller;

import com.yadhuwanshirahul.blog.application.Model.Post;
import com.yadhuwanshirahul.blog.application.PayLoad.PostDTO;
import com.yadhuwanshirahul.blog.application.PayLoad.PostResponse;
import com.yadhuwanshirahul.blog.application.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    @GetMapping
    public ResponseEntity<PostResponse> getAllPost(@RequestParam Integer pagesize, @RequestParam Integer pageNo){
        PostResponse response = postService.getAllPost(pagesize,pageNo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer postId){
        PostDTO post = postService.getPostById(postId);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
    @PostMapping("user/{userId}/categroy/{categoryId}")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO,@PathVariable Integer userId, @PathVariable Integer categoryId){
        PostDTO post = postService.createPost(postDTO,userId,categoryId);
        return new ResponseEntity<>(post,HttpStatus.CREATED);
    }
    @PutMapping("{postId}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO,@PathVariable Integer postId){
        PostDTO post = postService.updatePost(postDTO,postId);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
    @DeleteMapping("{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
        return new ResponseEntity<>(String.format("Post with %s deleted ",postId),HttpStatus.OK);
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<PostDTO>> getPostByCategory(@PathVariable Integer categoryId){
        List<PostDTO> response = postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDTO>> getPostByUser(@PathVariable Integer userId){
        List<PostDTO> response = postService.getPostByUser(userId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
