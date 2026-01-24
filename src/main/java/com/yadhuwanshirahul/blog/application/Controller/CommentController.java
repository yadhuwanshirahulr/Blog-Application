package com.yadhuwanshirahul.blog.application.Controller;

import com.yadhuwanshirahul.blog.application.PayLoad.CommentDTO;
import com.yadhuwanshirahul.blog.application.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("{postId}")
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO dto, @PathVariable Integer postId){
        CommentDTO response = commentService.createComment(dto,postId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @DeleteMapping("{commnetId}")
        public ResponseEntity<String> deleteComment(@PathVariable Integer commnetId){
            commentService.deleteComment(commnetId);
            return new ResponseEntity<>("Comment Deleted",HttpStatus.OK);
        }
}
