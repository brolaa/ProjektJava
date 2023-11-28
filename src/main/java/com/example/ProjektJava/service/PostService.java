package com.example.ProjektJava.service;

import com.example.ProjektJava.model.Post;
import com.example.ProjektJava.payload.request.PostRequest;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts();

    List<Post> getAllPostsFromCountry(String country);

    Optional<Post> getPostById(Long id);

    Post savePost(PostRequest postRequest);

    Optional<Post> updatePost(Long id, PostRequest postRequest);

    boolean deletePost(Long id);

}
