package vttp.batch5.paf.movies.models;

public class Director {

    private String name;
    private Integer numOfMovies;
    private Double revenue;
    private Double budget;
    private Double profitLoss;

    
    
    public Director() {
    }
    public Director(String name, Integer numOfMovies, Double revenue, Double budget, Double profitLoss) {
        this.name = name;
        this.numOfMovies = numOfMovies;
        this.revenue = revenue;
        this.budget = budget;
        this.profitLoss = profitLoss;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getNumOfMovies() {
        return numOfMovies;
    }
    public void setNumOfMovies(Integer numOfMovies) {
        this.numOfMovies = numOfMovies;
    }
    public Double getRevenue() {
        return revenue;
    }
    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }
    public Double getBudget() {
        return budget;
    }
    public void setBudget(Double budget) {
        this.budget = budget;
    }
    public Double getProfitLoss() {
        return profitLoss;
    }
    public void setProfitLoss(Double profitLoss) {
        this.profitLoss = profitLoss;
    }

    
    
}
