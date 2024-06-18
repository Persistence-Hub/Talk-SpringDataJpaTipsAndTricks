package com.thorben.janssen.talk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thorben.janssen.talk.model.Address;
import com.thorben.janssen.talk.model.Author;
import com.thorben.janssen.talk.model.AuthorId;
import com.thorben.janssen.talk.repositories.AuthorRepository;

@SpringBootTest
class TestRecord {

	@Autowired
	private AuthorRepository authorRepo;

	Logger log = LogManager.getLogger(this.getClass().getName());

	@Test
	public void testRecord() {
		log.info("... testRecord ...");

		Author a = new Author();
        a.setId(new AuthorId("Author-42"));
        a.setFirstName("Thorben");
        a.setLastName("Janssen");
        a.setAddress(new Address("Dorfstrasse 13", "MainTown", "12345"));

        log.info("Persist new Author entity.");
        authorRepo.save(a);

		Author a2 = authorRepo.findById(a.getId()).orElseThrow();
		log.info(a2);
	}

}
