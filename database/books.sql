CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `author` varchar(100) NOT NULL,
  `borrowed` tinyint NOT NULL,
  `borrowed_by` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_borrower` (`borrowed_by`),
  CONSTRAINT `fk_borrower` FOREIGN KEY (`borrowed_by`) REFERENCES `users` (`id`)
);
