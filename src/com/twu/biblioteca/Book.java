package com.twu.biblioteca;

import java.time.Instant;

public class Book {
    private int id;
    private String name;
    private String author;
    private Instant publishDate;
    private boolean isBooked;

    public Book(int id, String name, String author, Instant publishDate, boolean isBooked) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
        this.isBooked = isBooked;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return String.format("%-3s%-50s%-50s%-50s", id, name, author, publishDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Instant getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Instant publishDate) {
        this.publishDate = publishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
