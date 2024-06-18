package com.thorben.janssen.talk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thorben.janssen.talk.model.Author;
import com.thorben.janssen.talk.model.AuthorId;

public interface AuthorRepository extends JpaRepository<Author, AuthorId> {
    
}
