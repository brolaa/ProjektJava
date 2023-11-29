package com.example.ProjektJava.service;

import com.example.ProjektJava.model.Post;
import com.example.ProjektJava.payload.request.PostRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

// Single responsibility - klasa ma jeden główny cel - zmapować obiekt Post na PostRequest
@Component
public class PostMapper {
    public Post toPost(PostRequest postRequest) {
        return new Post(postRequest.getTitle(),
                postRequest.getDescription(),
                postRequest.getContent(),
                postRequest.getCountry(),
                LocalDate.parse(postRequest.getDepartDate()),
                LocalDate.parse(postRequest.getReturnDate()));
    }
}
