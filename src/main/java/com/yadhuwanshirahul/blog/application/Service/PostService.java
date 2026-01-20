package com.yadhuwanshirahul.blog.application.Service;

import com.yadhuwanshirahul.blog.application.Model.Post;
import com.yadhuwanshirahul.blog.application.PayLoad.PostDTO;
import com.yadhuwanshirahul.blog.application.PayLoad.PostResponse;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO post,Integer userId, Integer categoryId);
    PostDTO updatePost(PostDTO post, Integer postId);
    void deletePost(Integer postId);
    PostResponse getAllPost(Integer pagesize, Integer pageNo,String sortBy, String sortIn);
    PostDTO getPostById(Integer postId);
    List<PostDTO> getPostByCategory(Integer categoryId);
    List<PostDTO> getPostByUser(Integer userId);

    List<PostDTO> getAllPostByTitle(String title);
}
