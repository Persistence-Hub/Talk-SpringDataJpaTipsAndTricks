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
import com.thorben.janssen.talk.repositories.AuthorRepository;
import com.thorben.janssen.talk.repositories.BookRepository;

import jakarta.persistence.EntityManager;

@SpringBootTest
@Transactional
@Commit
class TestKeepAssociationOrder {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private AuthorRepository authorRepo;

	@Autowired
	private EntityManager em;

	Logger log = LogManager.getLogger(this.getClass().getName());

	@Test
	public void testOrder() {
		log.info("... testOrder ...");

		Book b = new Book();
		b.setTitle("My Book");
		bookRepo.save(b);

		Author a1 = new Author();
		a1.setFirstName("Author 1");
		authorRepo.save(a1);

		Author a2 = new Author();
		a2.setFirstName("Author 2");
		authorRepo.save(a2);

		a2.getBooks().add(b);
		b.getAuthors().add(a2);
		a1.getBooks().add(b);
		b.getAuthors().add(a1);

		em.flush();
		em.clear();

		Book readBook = bookRepo.findById(b.getId()).orElseThrow();
		
		Author[] authors = readBook.getAuthors().toArray(new Author[2]);
		assertEquals("Author 2", authors[0].getFirstName());
		assertEquals("Author 1", authors[1].getFirstName());
		for (Author a : authors) {
			log.info(a.getLastName() + ", id: " + a.getId());
		}
	}

}
