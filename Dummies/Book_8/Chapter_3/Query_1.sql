DROP DATABASE IF EXISTS movies;
CREATE DATABASE movies;
\c movies; -- Connect to the newly created database

CREATE TABLE movie (
    id SERIAL PRIMARY KEY,
    title VARCHAR(50),
    year INT,
    price DECIMAL(8,2)
);

INSERT INTO movie (title, year, price) 
VALUES 
('It''s a Wonderful Life', 1946, 14.95),
('Young Frankenstein', 1974, 16.95),
('Star Wars', 1977, 17.95),
('The Princess Bride', 1987, 16.95),
('Glory', 1989, 14.95),
('The Game', 1997, 14.95),
('Shakespeare in Love', 1998, 19.95),
('Zombieland', 2009, 18.95),
('The King''s Speech', 2010, 17.85),
('Star Trek Into Darkness', 2013, 19.95);

SELECT * FROM movie;
