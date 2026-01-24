package com.yadhuwanshirahul.blog.application.Service.impl;

import com.yadhuwanshirahul.blog.application.Exception.ResourceNotFoundException;
import com.yadhuwanshirahul.blog.application.Model.Comment;
import com.yadhuwanshirahul.blog.application.Model.Post;
import com.yadhuwanshirahul.blog.application.PayLoad.CommentDTO;
import com.yadhuwanshirahul.blog.application.Reposirtory.CommentRepo;
import com.yadhuwanshirahul.blog.application.Reposirtory.PostRepo;
import com.yadhuwanshirahul.blog.application.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    PostRepo postRepo;
    @Autowired
    CommentRepo commentRepo;
    @Override
    public CommentDTO createComment(CommentDTO commentDTO, Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()->
                new ResourceNotFoundException(
                        "postId",
                        "PostId",
                        String.valueOf(postId)
                ));
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setComment(commentDTO.getComment());
        commentRepo.save(comment);
        return  mapToDto(comment);
    }

    @Override
    public void deleteComment(int commentId) {
        commentRepo.deleteById(commentId);
    }
    private CommentDTO mapToDto(Comment comment){
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getCommentId());
        dto.setComment(comment.getComment());
        return dto;
    }
}
