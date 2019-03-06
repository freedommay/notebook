CREATE TABLE IF NOT EXISTS book (
  book_id INT(20) NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  number INT(10) NOT NULL,
  PRIMARY KEY (book_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS appointment (
  book_id INT(20) NOT NULL,
  student_id INT(20) NOT NULL,
  appoint_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (book_id, student_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO book (book_id, name, number)
VALUES
	(1000, 'book1', 10),
	(1001, 'book2', 10),
	(1002, 'book3', 10),
	(1003, 'book4', 10)
