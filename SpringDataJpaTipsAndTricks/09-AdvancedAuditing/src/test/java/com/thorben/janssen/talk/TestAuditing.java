package com.thorben.janssen.talk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thorben.janssen.talk.model.Book;
import com.thorben.janssen.talk.repositories.BookRepository;

@SpringBootTest
class TestAuditing {

	@Autowired
	private BookRepository bookRepo;

	Logger log = LogManager.getLogger(this.getClass().getName());

	@Test
	public void testOrder() {
		log.info("... testOrder ...");

		Book b = new Book();
        b.setTitle("Hibernate Tips");
        bookRepo.save(b);

		b.setTitle("Hibernate Tips - More than 70 solutions for common Hibernate problems");
		bookRepo.save(b);

		bookRepo.findRevisions(b.getId())
				.forEach(r -> log.info("Revision: " + r.getRevisionNumber().get() + " - " + r.getEntity()));
	}

}
