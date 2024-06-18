package com.thorben.janssen.talk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.thorben.janssen.talk.repositories.BookRepository;
import com.thorben.janssen.talk.repositories.TitleReviewCount;

@SpringBootTest
@Transactional
@Commit
class TestJoinUnassociated {

	@Autowired
	private BookRepository bookRepo;

	Logger log = LogManager.getLogger(this.getClass().getName());

	@Test
	public void joinUnassociated() {
		log.info("... joinUnassociated ...");

		TitleReviewCount titleReviewCount = bookRepo.findTitlesAndNumReviews();
		log.info(titleReviewCount.getTitle() + " received " + titleReviewCount.getNumReviews() + " reviews.");
	}

}
