package com.twu.biblioteca;

public class Movie {
    private int id;
    private String name;
    private int year;
    private String director;
    private double rating;
    private boolean isChecked;

    public Movie() {
    }

    public Movie(int id, String name, int year, String director, double rating, boolean isChecked) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
        return String.format("%-3s%-50s%-6s%-50s%-3s", id, name, year, director, rating);
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
