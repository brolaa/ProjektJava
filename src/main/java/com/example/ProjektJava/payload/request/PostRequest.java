package com.example.ProjektJava.payload.request;

import com.example.ProjektJava.validation.PostDate;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostRequest {
    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title cannot be longer than 100 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description cannot be longer than 255 characters")
    private String description;

    @NotBlank(message = "Post content is required")
    @Size(max = 1000, message = "Content cannot be longer than 1000 characters")
    private String content;

    @NotBlank(message = "Country is required")
    @Size(max = 100, message = "Country name cannot be longer than 100 characters")
    private String country;

    @PostDate
    @NotBlank(message = "Depart date is required")
    private String departDate;

    @PostDate
    @NotBlank(message = "Return date is required")
    private String returnDate;
}
