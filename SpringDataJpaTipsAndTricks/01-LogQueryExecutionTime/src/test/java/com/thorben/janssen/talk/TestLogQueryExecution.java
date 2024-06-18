package com.thorben.janssen.talk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.thorben.janssen.talk.model.Author;
import com.thorben.janssen.talk.repositories.AuthorRepository;

@SpringBootTest
@Transactional
@Commit
class TestLogQueryExecution {

	@Autowired
	private AuthorRepository authorRepo;

	@Test
	void testLogStatistics() {
		Author author = authorRepo.findAuthorById(1L);

		author.setFirstName("changed");
	}

}
