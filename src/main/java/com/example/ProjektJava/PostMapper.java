package com.example.ProjektJava;

import com.example.ProjektJava.model.Post;
import com.example.ProjektJava.payload.request.PostDto;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public Post toPost(PostDto postDto) {
        return new Post(postDto.getTitle(),
                postDto.getDescription(),
                postDto.getContent(),
                postDto.getCountry(),
                postDto.getDepartDate(),
                postDto.getDepartDate());
    }

    public PostDto PostDto(Post post) {
        return new PostDto(post.getTitle(),
                post.getDescription(),
                post.getContent(),
                post.getCountry(),
                post.getDepartDate(),
                post.getReturnDate());
    }
}
