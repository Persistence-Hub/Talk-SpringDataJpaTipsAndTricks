package com.thorben.janssen.talk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thorben.janssen.talk.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
    @Query("SELECT b FROM Book b JOIN FETCH b.authors a WHERE b.id = 2")
    Book findBookWithAuthors(Long id);
}
