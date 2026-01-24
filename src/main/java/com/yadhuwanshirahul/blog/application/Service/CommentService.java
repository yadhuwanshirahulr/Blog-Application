package com.yadhuwanshirahul.blog.application.Service;

import com.yadhuwanshirahul.blog.application.PayLoad.CommentDTO;

public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO,Integer postId);
    void deleteComment(int commentId);
}
