package com.example.ProjektJava.service;

import com.example.ProjektJava.model.Post;
import com.example.ProjektJava.payload.request.PostRequest;
import com.example.ProjektJava.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getPostsByCountry(String country) {
        return postRepository.findByCountry(country);
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post addPost(PostRequest postRequest) {
        return postRepository.save(postMapper.toPost(postRequest));
    }

    @Override
    public Optional<Post> updatePost(Long id, PostRequest postRequest) {
        return postRepository.findById(id)
                .map(existingPost -> {
                    Post updatedPost = postMapper.toPost(postRequest);
                    updatedPost.setId(existingPost.getId());
                    return postRepository.save(updatedPost);
                });
    }

    @Override
    public boolean deletePost(Long id) {
        return postRepository.findById(id)
                .map(post -> {
                    postRepository.delete(post);
                    return true;
                })
                .orElse(false);
    }
}
