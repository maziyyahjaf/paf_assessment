package vttp.batch5.paf.movies.services;

import java.util.List;
import vttp.batch5.paf.movies.models.*;
import vttp.batch5.paf.movies.repositories.MongoMovieRepository;
import vttp.batch5.paf.movies.repositories.MySQLMovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

  @Autowired
  private MongoMovieRepository mongoMovieRepository;

  @Autowired
  private MySQLMovieRepository mySQLMovieRepository;

  // TODO: Task 2
 
  public void insertMoviesIntoDB(List<Movie> movies) {

      if (mySQLMovieRepository.batchInsertMovies(movies, 25)) {
        mongoMovieRepository.batchInsertMovies(movies);
      };
      

     
  }
  

  // TODO: Task 3
  // You may change the signature of this method by passing any number of parameters
  // and returning any type
  public void getProlificDirectors(int count) {

  }


  // TODO: Task 4
  // You may change the signature of this method by passing any number of parameters
  // and returning any type
  public void generatePDFReport() {

  }

}
