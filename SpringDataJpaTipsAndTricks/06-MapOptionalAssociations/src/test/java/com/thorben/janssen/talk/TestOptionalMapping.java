package com.thorben.janssen.talk;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.thorben.janssen.talk.model.Book;
import com.thorben.janssen.talk.repositories.BookRepository;

@SpringBootTest
@Transactional
@Commit
class TestOptionalMapping {

	@Autowired
	private BookRepository bookRepo;

	Logger log = LogManager.getLogger(this.getClass().getName());

	@Test
	public void testOptional() {
		log.info("... testOptional ...");

		Book b = bookRepo.findById(1L).orElseThrow();
		assertTrue(b.getPublisher().isPresent());
		log.info(b.getTitle() + " was published by " + b.getPublisher().get().getName());
		
		b = bookRepo.findById(2L).orElseThrow();
		assertFalse(b.getPublisher().isPresent());
		log.info(b.getTitle() + " has no publisher");
	}

}
