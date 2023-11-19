package com.example.ProjektJava.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
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

    @Column(name = "depart_date", columnDefinition = "DATE")
    private LocalDate departDate;

    @Column(name = "return_date", columnDefinition = "DATE")
    private LocalDate returnDate;

    @Column(name = "creation_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime creationDate;

    public Post(String title, String description, String content, String country, LocalDate departDate, LocalDate returnDate) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.country = country;
        this.departDate = departDate;
        this.returnDate = returnDate;
        this.creationDate = LocalDateTime.now();
    }
}
