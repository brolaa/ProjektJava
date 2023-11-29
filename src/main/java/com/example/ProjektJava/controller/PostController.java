package com.example.ProjektJava.controller;

import com.example.ProjektJava.model.Post;
import com.example.ProjektJava.payload.request.PostRequest;
import com.example.ProjektJava.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<Post>> getPostsByCountry(@PathVariable("country") String country) {
        return ResponseEntity.ok(postService.getPostsByCountry(country));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
        return postService.getPostById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<Post> addPost(@Valid @RequestBody PostRequest postRequest) {
        Post savedPost = postService.addPost(postRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") long id, @RequestBody PostRequest postRequest) {
        return postService.updatePost(id, postRequest)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") long id) {
        return postService.deletePost(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
