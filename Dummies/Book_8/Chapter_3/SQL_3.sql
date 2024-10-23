use movies;

DROP TABLE IF EXISTS friend;

CREATE TABLE friend (
	lastname varchar(50),
    firstname varchar(50),
    movieid int
);


INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Haskell', 'Eddie', 3);

INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Haskell', 'Eddie', 5);

INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Cleaver', 'Wally', 9);

INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Mondello', 'Lumpy', 2);

INSERT INTO friend (lastname, firstname, movieid)
VALUES ('Cleaver', 'Wally', 3);

 
 SELECT firstname, lastname, title 
	FROM movie, friend 
		WHERE movie.id = friend.movieid;
 
 SELECT title from movie, friend
	WHERE movie.id = friend.movieid
    and lastname = "Haskell";
 
 SELECT DISTINCT lastname, firstname from friend;
 
 DELETE FROM movie WHERE id = 10;
 SELECT * FROM movie;
 
 DELETE FROM friend WHERE lastname = "Haskell";
 SELECT * FROM friend;
 
 UPDATE movie
	SET price = 180.95
		WHERE id = 8;
 
UPDATE friend SET lastname = "Bully",
	firstname = "Big" WHERE firstname = "Wally";
 
 UPDATE movie SET price = price * 1.1;
 SELECT * FROM movie;
 
 
 
 
 
 
 