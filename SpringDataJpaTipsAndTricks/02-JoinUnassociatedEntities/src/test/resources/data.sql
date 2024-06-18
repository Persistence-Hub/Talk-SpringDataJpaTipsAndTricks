INSERT INTO book (id, publishing_date, title, version) VALUES (1, '2017-04-04', 'Hibernate Tips', 0);

INSERT INTO review (id, comment, fk_Book) VALUES (1, 'This is a review', 1);
INSERT INTO review (id, comment, fk_Book) VALUES (2, 'This is another review', 1);