package com.thorben.janssen.talk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.thorben.janssen.talk.model.Book;
import com.thorben.janssen.talk.repositories.BookDto;
import com.thorben.janssen.talk.repositories.BookRecord;
import com.thorben.janssen.talk.repositories.BookRepository;
import com.thorben.janssen.talk.repositories.OpenBookDto;

@SpringBootTest
@Transactional
@Commit
class TestDynamicProjection {

	@Autowired
	private BookRepository bookRepo;

	Logger log = LogManager.getLogger(this.getClass().getName());

	@Test
	public void dynamicProjection() {
		log.info("... dynamicProjection ...");

		BookRecord bookRecord = bookRepo.findBookById(1L, BookRecord.class);
		log.info(bookRecord.title());

		BookDto bookDto = bookRepo.findBookById(1L, BookDto.class);
		log.info(bookDto.getTitle());

		Book book = bookRepo.findBookById(1L, Book.class);
		log.info(book.getTitle());
	}

	@Test
	public void openProjection() {
		log.info("... openProjection ...");

		OpenBookDto bookDto = bookRepo.findBookById(1L, OpenBookDto.class);
		log.info(bookDto.getIdWithTitle());
	}

}
