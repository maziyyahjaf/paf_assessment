DROP DATABASE IF EXISTS movies;
CREATE DATABASE movies;

USE movies;

SELECT "CREATING imdb TABLE.." as msg;
CREATE TABLE imdb(
    imdb_id VARCHAR(16) NOT NULL,
    vote_average FLOAT NOT NULL DEFAULT 0.0,
    vote_count INT NOT NULL DEFAULT 0,
    release_date DATE,
    revenue DECIMAL(15,2) NOT NULL DEFAULT 1000000.00,
    budget DECIMAL(15,2) NOT NULL DEFAULT 1000000.00,
    runtime INT NOT NULL DEFAULT 90,

    CONSTRAINT pk_imdb_id PRIMARY KEY (imdb_id)
);


GRANT ALL PRIVILEGES ON movies.* to 'fred'@'%';
FLUSH PRIVILEGES;