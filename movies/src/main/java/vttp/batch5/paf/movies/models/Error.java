package vttp.batch5.paf.movies.models;

import java.time.LocalDateTime;
import java.util.List;

public class Error {

    private List<String> imdbIds;
    private String error;
    private LocalDateTime timestamp;

    
    
    public Error() {
    }
    
    public Error(List<String> imdbIds, String error, LocalDateTime timestamp) {
        this.imdbIds = imdbIds;
        this.error = error;
        this.timestamp = timestamp;
    }
    public List<String> getImdbIds() {
        return imdbIds;
    }
    public void setImdbIds(List<String> imdbIds) {
        this.imdbIds = imdbIds;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    
    
}
