package com.twu.biblioteca;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private static List<Book> bookList = new ArrayList();

    public static void main(String[] args) {
        initBookList();
        printWelcomeMessage();
        printBookList();
    }

    static void printWelcomeMessage() {
        System.out.println("Welcome to Bangalore Public Library!");
    }

    static void printBookList() {
        System.out.println("Here is the list of the books.");
        System.out.println(String.format("%-50s%-50s%-50s","---BOOK NAME---", "---AUTHOR---", "---PUBLISH DATE---"));
        for(Book book : bookList) {
            System.out.println(book.toString());
        }
    }

    private static void initBookList() {
        bookList.add(new Book("The Ragged Edge of Night", "Olivia Hawker", Instant.now()));
        bookList.add(new Book("What Have You Done", "Matthew Farrell", Instant.now()));
        bookList.add(new Book("We Were Mothers: A Novel", "Katie Sise", Instant.now()));
        bookList.add(new Book("The Rule of One", "Ashley Saunders", Instant.now()));
        bookList.add(new Book("You've Been So Lucky Already: A Memoir", "Alethea Black", Instant.now()));
    }
}
