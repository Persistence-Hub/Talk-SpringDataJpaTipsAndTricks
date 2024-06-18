package com.thorben.janssen.talk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import com.thorben.janssen.talk.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>, RevisionRepository<Book, Long, Long> {
    
}
