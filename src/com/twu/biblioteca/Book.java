package com.twu.biblioteca;

import java.time.Instant;

public class Book {
    String name;
    String author;
    Instant publishDate;

    public Book(String name, String author, Instant publishDate) {
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return String.format("%-50s%-50s%-50s", name, author, publishDate);
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
}
