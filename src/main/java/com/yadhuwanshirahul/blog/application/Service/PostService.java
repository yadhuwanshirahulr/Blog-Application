package com.yadhuwanshirahul.blog.application.Service;

import com.yadhuwanshirahul.blog.application.Model.Post;
import com.yadhuwanshirahul.blog.application.PayLoad.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO post,Integer userId, Integer categoryId);
    PostDTO updatePost(PostDTO post, Integer postId);
    void deletePost(Integer postId);
    List<PostDTO> getAllPost();
    PostDTO getPostById(Integer postId);
    List<PostDTO> getPostByCategory(Integer categoryId);
    List<PostDTO> getPostByUser(Integer userId);
}
