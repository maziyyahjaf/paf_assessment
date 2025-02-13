package vttp.batch5.paf.movies.bootstrap;




import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import vttp.batch5.paf.movies.models.Movie;
import vttp.batch5.paf.movies.services.MovieService;
import vttp.batch5.paf.movies.utils.Utils;

@Component
public class Dataloader implements CommandLineRunner {

  // @Value("${zipped.file.path}")
  // String source;

  // @Value("${unzipped.file.path}")
  // String destination;

  public static final Logger logger = LoggerFactory.getLogger(Dataloader.class);

  @Value("${json.file.path}")
  String jsonFilePath;

  @Autowired
  private ResourceLoader resourceLoader;

  @Autowired
  private MovieService movieService;
  //TODO: Task 2

  @Override
  public void run(String... args) throws Exception {

   try {

      String endDateString = "2018-01-01";

      Date endDate = Date.valueOf(endDateString);

      String zipName = "/Users/maziyyah/Documents/paf_assessment_feb2025-main/paf_b5_assessment_template/data/movies_post_2010.zip";

      
      // Resource resource = resourceLoader.getResource(jsonFilePath);

      try (FileInputStream fis = new FileInputStream(zipName);
          ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis))) {
            ZipEntry entry;
            
            while ((entry = zis.getNextEntry()) != null) {
              logger.info("unzipping: " + entry.getName());
              int size;
              byte[] buffer = new byte[2048];

              try (FileOutputStream fos = new FileOutputStream(entry.getName());
                  BufferedOutputStream bos = new BufferedOutputStream(fos, buffer.length)) {
                    while((size = zis.read(buffer, 0, buffer.length)) != -1) {
                      bos.write(buffer, 0, size);
                    }
                    bos.flush();
                  }
            

            }
          }

          File jsonFile = new File("/Users/maziyyah/Documents/paf_assessment_feb2025-main/paf_b5_assessment_template/data/movies_post_2010.json");
          List<Movie> movies = new ArrayList<>();
          try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
            String line;
            while((line = reader.readLine()) != null) {
              //convert each line of JsonObject into a Movie Object??
              // logger.info("line: {}", line);
              JsonReader jsonReader = Json.createReader(new StringReader(line));
              JsonObject jsonObject = jsonReader.readObject();
              Movie movie = Utils.toMovie(jsonObject);
          
              movies.add(movie);
            }
          }

          // logger.info("movie list, {}", movies);

          List<Movie> newMovieList = movies.stream().filter(m -> m.getReleasedDate().after(endDate))
                                                          .collect(Collectors.toList());


          Movie filteredMovie = newMovieList.get(0);
          logger.info("one filtered movie: {}", filteredMovie);

          movieService.insertMoviesIntoDB(newMovieList);




      // try (InputStream inputStream = resource.getInputStream();
      //     JsonReader jsonReader = Json.createReader(inputStream)) {
      //       logger.info("Reading Json Object..turning into Movie object..");
      //       // it is not an array -> it is a file of json objects
      //       List<Movie> movies = new ArrayList<>();
      //       JsonArray rootArray = jsonReader.readArray();
      //       for (JsonObject jsonObject : rootArray.getValuesAs(JsonObject.class)) {
      //         logger.info("one json object {}", jsonObject);
      //         Movie movie = Utils.toMovie(jsonObject);
      //         logger.info("one movie {}", movie);
      //         movies.add(movie);
  

      //       }
          
      //       logger.info("movie list, {}", movies);

      //       // how to filter movies after 2018
      //       List<Movie> newMovieList = movies.stream().filter(m -> m.getReleasedDate().after(endDate))
      //                                                 .collect(Collectors.toList());
      //       // Movie filteredMovie = newMovieList.get(0);
      //       // logger.info("one filtered movie: {}", filteredMovie);

      //       // now need to save to db?
      //       movieService.insertMoviesIntoDB(newMovieList);

      //     }

   } catch (IOException | jakarta.json.JsonException e) {
    	
      logger.error("Error reading or parsing JSON file: {}", e.getMessage(), e);

   }
    
  }



}
