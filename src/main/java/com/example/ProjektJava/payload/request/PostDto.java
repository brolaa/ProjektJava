package com.example.ProjektJava.payload.request;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class PostDto {
    private String title;

    @NotBlank
    @Size(max = 255)
    private String description;

    @NotBlank
    @Size(max = 1000)
    private String content;

    @NotBlank
    @Size(max = 100)
    private String country;

    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date departDate;

    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date returnDate;
}
