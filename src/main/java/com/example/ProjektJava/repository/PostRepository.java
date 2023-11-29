package com.example.ProjektJava.repository;

import com.example.ProjektJava.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Interface Segregation Principle - interfejsy repozytorium są rozdzielone dla każdej klasy encyjnej
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCountry(String country);
}
