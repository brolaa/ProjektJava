package com.example.ProjektJava.service;

import com.example.ProjektJava.model.Post;
import com.example.ProjektJava.payload.request.PostRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class PostMapper {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd");

    public Post toPost(PostRequest postRequest) {
        return new Post(postRequest.getTitle(),
                postRequest.getDescription(),
                postRequest.getContent(),
                postRequest.getCountry(),
                LocalDate.parse(postRequest.getDepartDate(), DATE_FORMATTER),
                LocalDate.parse(postRequest.getReturnDate(), DATE_FORMATTER));
    }

    public PostRequest toPostRequest(Post post) {
        return new PostRequest(post.getTitle(),
                post.getDescription(),
                post.getContent(),
                post.getCountry(),
                post.getDepartDate().format(DATE_FORMATTER),
                post.getReturnDate().format(DATE_FORMATTER));
    }
}
