package com.yadhuwanshirahul.blog.application.Service.impl;

import com.yadhuwanshirahul.blog.application.Exception.ResourceNotFoundException;
import com.yadhuwanshirahul.blog.application.Model.Category;
import com.yadhuwanshirahul.blog.application.Model.Post;
import com.yadhuwanshirahul.blog.application.Model.User;
import com.yadhuwanshirahul.blog.application.PayLoad.PostDTO;
import com.yadhuwanshirahul.blog.application.PayLoad.PostResponse;
import com.yadhuwanshirahul.blog.application.Reposirtory.CategoryRepo;
import com.yadhuwanshirahul.blog.application.Reposirtory.PostRepo;
import com.yadhuwanshirahul.blog.application.Reposirtory.UserRepo;
import com.yadhuwanshirahul.blog.application.Service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    UserRepo userRepo;
    Date date;
    @Override
    public  PostDTO createPost(PostDTO post,Integer userId, Integer categoryId) {
        Post newPost = mapToPost(post);
        Category category = categoryRepo.findById(categoryId).get();
        User user = userRepo.findById(userId).get();
        newPost.setImageName("Default.jpg");
        newPost.setAddedDate();
        newPost.setCategory(category);
        newPost.setUser(user);
        postRepo.save(newPost);
        return mapToDto(newPost);
    }

    private PostDTO mapToDto(Post newPost) {
        PostDTO post = modelMapper.map(newPost,PostDTO.class);
        return post;
    }

    @Override
    @Transactional
    public PostDTO updatePost(PostDTO post, Integer postId) {
       Post dbPost = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException(
               "Post",
               "postId",
               String.valueOf(postId)
       ));
       dbPost.setContent(post.getContent());
       dbPost.setTitle(post.getTitle());
       return mapToDto(dbPost);
    }

    @Override
    public void deletePost(Integer postId) {
        postRepo.deleteById(postId);
    }

    @Override
    public PostResponse getAllPost(Integer pagesize, Integer pageNo) {
       Pageable page = PageRequest.of(pageNo,pagesize);
        Page<Post> post = postRepo.findAll(page);
        List<Post> posts =post.getContent();
        List<PostDTO> postDTOS = new ArrayList<>();
        for(Post p:posts){
            postDTOS.add(mapToDto(p));
        }
        PostResponse response = new PostResponse();
        response.setPost(postDTOS);
        response.setPageNo(post.getNumber());
        response.setTotalElement(post.getTotalElements());
        response.setPageSize(post.getSize());
        response.setTotalPage(post.getTotalPages());
        response.setLast(post.isLast());
        return response;
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException(
                "Post",
                "postId",
                String.valueOf(postId)
        ));
        return mapToDto(post);
    }

    @Override
    public List<PostDTO> getPostByCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException(
                "Category",
                "CategoryId",
                categoryId.toString()
        ));
        List<Post> posts = postRepo.findByCategory(category);
        List<PostDTO> response = posts.stream()
                .map(post -> mapToDto(post))
                .collect(Collectors.toList());
        return response;
    }

    @Override
    public List<PostDTO> getPostByUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException(
                "Category",
                "CategoryId",
                userId.toString()
        ));
        List<Post> posts = postRepo.findByUser(user);
        List<PostDTO> response = posts.stream()
                .map(post->mapToDto(post))
                .collect(Collectors.toList());
        return response;
    }
    private Post mapToPost(PostDTO postDTO){
        Post post = modelMapper.map(postDTO,Post.class);
        return post;
    }
}
