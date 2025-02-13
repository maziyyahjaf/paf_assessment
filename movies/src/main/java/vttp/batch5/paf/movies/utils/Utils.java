package vttp.batch5.paf.movies.utils;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import vttp.batch5.paf.movies.models.Director;
import vttp.batch5.paf.movies.models.Movie;

public class Utils {

    public static Movie toMovie(JsonObject jsonObj) {

        Movie movie = new Movie();
        String title = jsonObj.getString("title", "");
        movie.setTitle(title);
        Integer voteAverage = Optional.ofNullable(jsonObj.getJsonNumber("vote_average").intValue()).orElse(0);
        movie.setVoteAverage(voteAverage);
        Integer voteCount = Optional.ofNullable(jsonObj.getJsonNumber("vote_count").intValue()).orElse(0);
        movie.setVoteCount(voteCount);
        String status = jsonObj.getString("status", "");
        movie.setStatus(status);
        String releaseDate = jsonObj.getString("release_date", "");
        Date sqlDate = Date.valueOf(releaseDate);
        movie.setReleasedDate(sqlDate);
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // try {
        //     Date date = sdf.parse(releaseDate);
        //     movie.setReleasedDate(date);
        // } catch (ParseException e) {
        //     Date date = new Date();
        //     movie.setReleasedDate(date);
        // }

        Integer revenue = Optional.ofNullable(jsonObj.getJsonNumber("revenue").intValue()).orElse(0);
        movie.setRevenue(revenue);
        Integer runtime = Optional.ofNullable(jsonObj.getJsonNumber("runtime").intValue()).orElse(0);
        movie.setRuntime(runtime);
       Integer budget = Optional.ofNullable(jsonObj.getJsonNumber("budget").intValue()).orElse(0);
        movie.setBudget(budget);
        String imdbId = jsonObj.getString("imdb_id", "");
        movie.setImdbId(imdbId);
        String originalLanguage = jsonObj.getString("original_language", "");
        movie.setOriginalLanguage(originalLanguage);
        String overview = jsonObj.getString("overview", "");
        movie.setOverview(overview);
        Integer popularity = Optional.ofNullable(jsonObj.getJsonNumber("popularity").intValue()).orElse(0);
        movie.setPopularity(popularity);
        String tagline = jsonObj.getString("tagline", "");
        movie.setTagline(tagline);
        String genres = jsonObj.getString("genres");
        movie.setGenres(genres);
        String spokenLanguages = jsonObj.getString("spoken_languages", "");
        movie.setSpokenLanguages(spokenLanguages);
        String casts = jsonObj.getString("casts", "");
        movie.setCasts(casts);
        String director = jsonObj.getString("director", "");
        movie.setDirector(director);
        Integer imdbRating = jsonObj.get("imdb_rating") != JsonValue.NULL ? jsonObj.getJsonNumber("imdb_rating").intValue() : 0;
        movie.setImdbRating(imdbRating);
        Integer imdbVotes = jsonObj.get("imdb_votes") != JsonValue.NULL ? jsonObj.getJsonNumber("imdb_votes").intValue() : 0;
        movie.setImdbVotes(imdbVotes);
        String posterPath = jsonObj.getString("poster_path", "");
        movie.setPosterPath(posterPath);

        return movie;

        
    }

    public static Document fromMovieToDocument(Movie movie) {
        Document document = new Document();
        document.append("_id", movie.getImdbId());
        document.append("title", movie.getTitle());
        document.append("director", movie.getDirector());
        document.append("overview", movie.getOverview());
        document.append("tagline", movie.getTagline());
        document.append("genres", movie.getGenres());
        document.append("imdb_rating", movie.getImdbRating());
        document.append("imdb_votes", movie.getImdbVotes());
        
        return document;
    }

    public static JsonObject fromDirectorToJson(Director dir) {
        JsonObject jsonObj = Json.createObjectBuilder()
                                    .add("directorName", dir.getName())
                                    .add("movies", dir.getNumOfMovies())
                                    .add("revenue", dir.getRevenue())
                                    .add("budget", dir.getBudget())
                                    .add("profit/loss", dir.getProfitLoss())
                                    .build();
        return jsonObj;
    }

    
}
