package vttp.batch5.paf.movies.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import vttp.batch5.paf.movies.exceptions.AddMovieIntoSqlException;
import vttp.batch5.paf.movies.models.Movie;

@Repository
public class MySQLMovieRepository {

  private static final Logger logger = LoggerFactory.getLogger(MySQLMovieRepository.class);


  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  // TODO: Task 2.3
  // You can add any number of parameters and return any type from the method
  
  public boolean batchInsertMovies(List<Movie> movies, int batchSize) {


    List<Movie> sucessfullyInserted = new ArrayList<>();
    logger.info("Entering backinsertMovies for sql..");
    // first i need to change util date to sql date ?? try first
    List<Object[]> params = movies.stream()
                            .map(movie -> new Object[]{
                              movie.getImdbId(),
                              movie.getVoteAverage(),
                              movie.getVoteCount(),
                              movie.getReleasedDate(),
                              movie.getRevenue(),
                              movie.getBudget(),
                              movie.getRuntime()
                            })
                            .collect(Collectors.toList());
    try {
        int[][] results = jdbcTemplate.batchUpdate(Queries.SQL_INSERT_MOVIE, movies, batchSize, new ParameterizedPreparedStatementSetter<Movie>() {

          @Override
          public void setValues(PreparedStatement ps, Movie movie) throws SQLException {
            ps.setString(1, movie.getImdbId());
            ps.setFloat(2, movie.getVoteAverage());
            ps.setInt(3, movie.getVoteCount());
            ps.setDate(4, movie.getReleasedDate());
            ps.setObject(5, movie.getRevenue());
            ps.setObject(6, movie.getBudget());
            ps.setInt(7, movie.getRuntime());
          }
          
        });
    
        //need to do batch insert in 25?

        return true;


    } catch (DataAccessException ex) {
      // how to get the ids??
      logger.error("SQL Error: {} - {}", ex.getMessage(), ex.getCause());
      logger.warn("Duplicate entry  detected in batch update..skipping duplicates");
      return false;
      // throw new AddMovieIntoSqlException(ex.getMessage());
      // need to record the exceptions??

    }



  }

  
  
  // TODO: Task 3


}
