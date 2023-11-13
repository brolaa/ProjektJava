package com.example.ProjektJava.repository;

import com.example.ProjektJava.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCountry(String country);
    List<Post> findByTitleContaining(String title);
}
