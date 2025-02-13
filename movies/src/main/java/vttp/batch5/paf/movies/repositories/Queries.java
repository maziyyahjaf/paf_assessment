package vttp.batch5.paf.movies.repositories;

public class Queries {

    public static final String SQL_INSERT_MOVIE = 
            """
                INSERT INTO imdb(imdb_id, vote_average, vote_count, release_date, revenue, budget, runtime)
                VALUES (?, ?, ?, ?, ?, ?, ?)
            
            """;
    public static final String SQL_FIND_INFO_FOR_EACH_IMDB_ID = 
            """

                SELECT *
                FROM imdb
                WHERE imdb_id = ?

            
            """;
  
}
