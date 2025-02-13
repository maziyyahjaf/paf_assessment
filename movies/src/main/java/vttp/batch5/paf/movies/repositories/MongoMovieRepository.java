package vttp.batch5.paf.movies.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.SetOperation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import vttp.batch5.paf.movies.models.Movie;
import vttp.batch5.paf.movies.utils.Utils;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Repository
public class MongoMovieRepository {

    private static final Logger logger = LoggerFactory.getLogger(MongoMovieRepository.class);

    @Autowired
    private MongoTemplate mongoTemplate;


 // TODO: Task 2.3
 // You can add any number of parameters and return any type from the method
 // You can throw any checked exceptions from the method
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
/*
 *    db.imdb.insertMany([
 *      {_id: "abc", ...},
 *      {_id: "def", ...}])
 * 
 */

 //
 public void batchInsertMovies(List<Movie> movies) {
    logger.info("Entering batchInsertMovies for mongo..");
    // need to convert Movie Object to a Document Object

    int batchSize = 25;

    List<Document> movieDocList = new ArrayList<>();
    for (Movie movie : movies) {
        Document doc = Utils.fromMovieToDocument(movie);
        movieDocList.add(doc);
    }

    for (int i = 0; i < movieDocList.size(); i+= batchSize) {
        List<Document> batch = movieDocList.subList(i, Math.min(i+batchSize, movieDocList.size()));
        mongoTemplate.insert(batch, "imdb");
    }


    //  Collection<Document> insertedDocs = mongoTemplate.insert(movieDocList, "imdb");
    
    
   

   


 }

 // TODO: Task 2.4
 // You can add any number of parameters and return any type from the method
 // You can throw any checked exceptions from the method
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 //
 public void logError() {

 }

 // TODO: Task 3
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here


 /*
  * 
        db.imdb.aggregate([
                {$group: {
                    "_id": "$director",
                    "movies": {$push: "$title"},

                
                }}
        
        
        ])
    // first need to get the number of movies for each director
    // count the number of movies for each director
    // you need the imdb_id
    // sort by the number of movies
    // for each movie -> get the imdb_id


    db.imdb.aggregate([
                {
                    
                        $group: {
                            "_id": "$director",
                            "imdb_id": {$push: "$_id"},
                            "movies" : {$push: "$title"}
                        }
                    
                },
                
                {
                    $set: {"movie_count": {"$size": "$movies"}}
                },
                
                {
                    $sort : {"movie_count": -1}
                }
        ])

  */
 //
        public void getTopDirectors(int count) {
            GroupOperation groupOps = Aggregation.group("director")
                                    .push("_id").as("imdb_id")
                                    .push("title").as("movies");
          

        }


}
