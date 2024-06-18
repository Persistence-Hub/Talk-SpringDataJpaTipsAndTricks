package com.thorben.janssen.talk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thorben.janssen.talk.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
    <T> T findBookById(Long id, Class<T> type);
}
