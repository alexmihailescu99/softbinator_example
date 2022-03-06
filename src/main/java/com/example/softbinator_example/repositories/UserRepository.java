package com.example.softbinator_example.repositories;

import com.example.softbinator_example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // - Un repository este folosit pentru a lucra cu un model din DB(retrieve, add , update)
// Mereu extindem JpaRepository<Model, Long>, unde Model - clasa model cu care vrem sa lucram
public interface UserRepository extends JpaRepository<User, Long> {
    // Query-urile sunt generate automat
    // Putem adauga si noi query-uri cu annotation @Query()
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
}
