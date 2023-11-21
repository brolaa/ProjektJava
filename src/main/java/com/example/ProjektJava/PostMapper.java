package com.example.ProjektJava;

import com.example.ProjektJava.model.Post;
import com.example.ProjektJava.payload.request.PostRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class PostMapper {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd");

    public Post toPost(PostRequest postRequest){
        return new Post(postRequest.getTitle(),
                postRequest.getDescription(),
                postRequest.getContent(),
                postRequest.getCountry(),
                LocalDate.parse(postRequest.getDepartDate(), DATE_FORMATTER),
                LocalDate.parse(postRequest.getReturnDate(), DATE_FORMATTER));
    }

    /*
    public PostDto PostDto(Post post) {
        return new PostDto(post.getTitle(),
                post.getDescription(),
                post.getContent(),
                post.getCountry(),
                post.getDepartDate(),
                post.getReturnDate());
    }
     */
}
