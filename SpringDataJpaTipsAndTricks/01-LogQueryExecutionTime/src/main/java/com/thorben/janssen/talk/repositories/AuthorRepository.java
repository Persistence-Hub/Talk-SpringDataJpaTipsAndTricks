package com.thorben.janssen.talk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thorben.janssen.talk.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
    Author findAuthorById(Long id);
}
