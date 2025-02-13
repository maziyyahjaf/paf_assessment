package vttp.batch5.paf.movies.models;

import java.sql.Date;

public class Movie {

    private String title;
    private Integer voteAverage;
    private Integer voteCount;
    private String status;
    private Date releasedDate;
    private Integer revenue; // may need to change data type
    private Integer runtime;
    private Integer budget;
    private String imdbId;
    private String originalLanguage;
    private String overview;
    private Integer popularity;
    private String tagline;
    private String genres;
    private String spokenLanguages;
    private String casts;
    private String director;
    private Integer imdbRating;
    private Integer imdbVotes;
    private String posterPath;


    
    public Movie() {
    }

    
    
    
    




    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getVoteAverage() {
        return voteAverage;
    }
    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }
    public Integer getVoteCount() {
        return voteCount;
    }
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
 
    public Integer getRuntime() {
        return runtime;
    }
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    
    public String getImdbId() {
        return imdbId;
    }
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
    public String getOriginalLanguage() {
        return originalLanguage;
    }
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public Integer getPopularity() {
        return popularity;
    }
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }
    public String getTagline() {
        return tagline;
    }
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
    public String getGenres() {
        return genres;
    }
    public void setGenres(String genres) {
        this.genres = genres;
    }
    public String getSpokenLanguages() {
        return spokenLanguages;
    }
    public void setSpokenLanguages(String spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }
    public String getCasts() {
        return casts;
    }
    public void setCasts(String casts) {
        this.casts = casts;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public Integer getImdbRating() {
        return imdbRating;
    }
    public void setImdbRating(Integer imdbRating) {
        this.imdbRating = imdbRating;
    }
    public Integer getImdbVotes() {
        return imdbVotes;
    }
    public void setImdbVotes(Integer imdbVotes) {
        this.imdbVotes = imdbVotes;
    }
    public String getPosterPath() {
        return posterPath;
    }
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }


  









    public Integer getRevenue() {
        return revenue;
    }









    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }









    public Integer getBudget() {
        return budget;
    }









    public void setBudget(Integer budget) {
        this.budget = budget;
    }









    public Date getReleasedDate() {
        return releasedDate;
    }









    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }









    @Override
    public String toString() {
        return "Movie [title=" + title + ", voteAverage=" + voteAverage + ", voteCount=" + voteCount + ", status="
                + status + ", releasedDate=" + releasedDate + ", revenue=" + revenue + ", runtime=" + runtime
                + ", budget=" + budget + ", imdbId=" + imdbId + ", originalLanguage=" + originalLanguage + ", overview="
                + overview + ", popularity=" + popularity + ", tagline=" + tagline + ", genres=" + genres
                + ", spokenLanguages=" + spokenLanguages + ", casts=" + casts + ", director=" + director
                + ", imdbRating=" + imdbRating + ", imdbVotes=" + imdbVotes + ", posterPath=" + posterPath + "]";
    }

    


    

    


    
}
