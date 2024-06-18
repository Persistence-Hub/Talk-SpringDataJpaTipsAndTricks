package com.thorben.janssen.talk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thorben.janssen.talk.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
    @Query("SELECT b.title as title, count(r.id) as numReviews FROM Book b INNER JOIN Review r ON r.fkBook = b.id GROUP BY b.title")
    TitleReviewCount findTitlesAndNumReviews();
}
