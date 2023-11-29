package com.example.ProjektJava.service;

import com.example.ProjektJava.model.Post;
import com.example.ProjektJava.payload.request.PostRequest;

import java.util.List;
import java.util.Optional;

// Open/Close Principle - tworząc implementacje serwisu można roszerzyć system nie modyfikując kodu
// Liskov principle - PostService i jego imlementacja PostServiceImpl mogą być stosowane na zmianę
public interface PostService {
    List<Post> getAllPosts();

    List<Post> getPostsByCountry(String country);

    Optional<Post> getPostById(Long id);

    Post addPost(PostRequest postRequest);

    Optional<Post> updatePost(Long id, PostRequest postRequest);

    boolean deletePost(Long id);

}
