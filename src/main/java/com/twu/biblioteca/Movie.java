package com.twu.biblioteca;

import static com.twu.biblioteca.CustomInputOutput.printOutput;

public class Movie {
    private final String name;
    private final String year;
    private final String director;
    private final String rating;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public void viewMovieDetails() {
        String columnSeparator = " | ";
        printOutput(this.name + columnSeparator + this.year + columnSeparator + this.director + columnSeparator + this.rating);
    }

    public boolean checkMovieByName(String movieName) {
        return this.name.equals(movieName);
    }
}
