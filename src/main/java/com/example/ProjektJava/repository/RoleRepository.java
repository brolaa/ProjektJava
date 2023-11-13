package com.example.ProjektJava.repository;

import com.example.ProjektJava.model.ERole;
import com.example.ProjektJava.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
