package com.thorben.janssen.talk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.thorben.janssen.talk.model.Author;
import com.thorben.janssen.talk.model.Book;
import com.thorben.janssen.talk.repositories.BookRepository;

@SpringBootTest
@Transactional
@Commit
class TestOrderAssociation {

	@Autowired
	private BookRepository bookRepo;

	Logger log = LogManager.getLogger(this.getClass().getName());

	@Test
	public void testOrder() {
		log.info("... testOrder ...");

		Book book = bookRepo.findById(2L).orElseThrow();
		Author[] authors = book.getAuthors().toArray(new Author[3]);
		assertEquals("Bauer", authors[0].getLastName());
		assertEquals("Gregory", authors[1].getLastName());
		assertEquals("King", authors[2].getLastName());
		for (Author a : authors) {
			log.info(a.getLastName() + ", id: " + a.getId());
		}
	}

	@Test
	public void testOrderJoinFetch() {
		log.info("... fetchBooksAndAuthors ...");

		Book book = bookRepo.findBookWithAuthors(2L);
		Author[] authors = book.getAuthors().toArray(new Author[3]);
		assertEquals("Bauer", authors[0].getLastName());
		assertEquals("Gregory", authors[1].getLastName());
		assertEquals("King", authors[2].getLastName());
		for (Author a : authors) {
			log.info(a.getLastName() + ", id: " + a.getId());
		}
	}

}
