package com.example.user.mvpretrofitrxjava2.TopMovies;




public class MovieData {

    private String country;
    private String name;

    public MovieData(String name, String country) {
        this.country = country;
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
