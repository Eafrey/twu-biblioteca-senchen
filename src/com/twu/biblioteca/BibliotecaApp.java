package com.twu.biblioteca;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private UserChecker userChecker = new UserChecker();
    private String libraryNumber = "";

    public List<Book> bookList = new ArrayList();
    public List<Movie> movieList = new ArrayList();

    public BibliotecaApp() {
        initBookList();
        initMovieList();
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.printWelcomeMessage();
        bibliotecaApp.listMenu();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.next();
            if (command.equals("q")) {
                break;
            }
            bibliotecaApp.handlerInputMenuOption(command);
        }
    }

    void handlerInputMenuOption(String command) {
        Scanner scanner = new Scanner(System.in);
        switch (command) {
            case "li":
                System.out.println("enter library number:");
                String ln = scanner.next();
                System.out.println("enter password");
                String p = scanner.next();
                if(userLogin(ln, p)) {
                    System.out.println("log in success!");
                } else {
                    System.out.println("log in fail!");
                }
                break;
            case "si":
                showUserInfo();
                break;
            case "lb":
                printBookList();
                break;
            case "cb":
                System.out.println("input book id you want to checkout:");
                int checkoutBookId = scanner.nextInt();
                checkoutBook(checkoutBookId);
                break;
            case "rb":
                System.out.println("input book id you want to return:");
                int returnBookId = scanner.nextInt();
                returnBook(returnBookId);
                break;
            case "lm":
                printMovieList();
                break;
            case "cm":
                System.out.println("input movie id you want to checkout:");
                int checkoutMovieId = scanner.nextInt();
                checkoutBook(checkoutMovieId);
                break;
            default:
                System.out.println("Select a valid option!");
                break;
        }
    }

    public void showUserInfo() {
    }


    void printWelcomeMessage() {
        System.out.println("Welcome to Bangalore Public Library!");
        System.out.println("If you wanto checkout book, please first login.");
    }

    void printBookList() {
        System.out.println("Here is the list of the books.");
        System.out.println(String.format("%-3s%-50s%-50s%-50s", "ID", "---BOOK NAME---", "---AUTHOR---", "---PUBLISH DATE---"));
        for (Book book : bookList) {
            if (!book.isBooked()) {
                System.out.println(book.toString());
            }
        }
    }

    void initBookList() {
        bookList.add(new Book(1, "The Ragged Edge of Night", "Olivia Hawker", Instant.now(), false));
        bookList.add(new Book(2, "What Have You Done", "Matthew Farrell", Instant.now(), false));
        bookList.add(new Book(3, "We Were Mothers: A Novel", "Katie Sise", Instant.now(), false));
        bookList.add(new Book(4, "The Rule of One", "Ashley Saunders", Instant.now(), false));
        bookList.add(new Book(5, "You've Been So Lucky Already: A Memoir", "Alethea Black", Instant.now(), false));
    }

    void listMenu() {
        System.out.println("---------------MENU---------------");
        System.out.println(String.format("%-15s -> press 'li'", "log in"));
        System.out.println(String.format("%-15s -> press 'si'", "show user info"));
        System.out.println(String.format("%-15s -> press 'lb'", "List Books"));
        System.out.println(String.format("%-15s -> press 'cb'", "Checkout Book"));
        System.out.println(String.format("%-15s -> press 'rb'", "Return Book"));
        System.out.println(String.format("%-15s -> press 'lm'", "List Movies"));
        System.out.println(String.format("%-15s -> press 'cm'", "Checkout Movie"));
        System.out.println(String.format("%-15s -> press 'q'", "Quit"));
    }

    public void checkoutBook(int bookId) {
        if (checkLogin()) return;
        for (Book book : bookList) {
            if (book.getId() == bookId) {
                if (book.isBooked()) {
                    System.out.println("That book is not available.");
                } else {
                    book.setUserName(libraryNumber);
                    book.setBooked(true);
                    System.out.println("Thank you! Enjoy the book.");
                }
                break;
            }
        }
    }

    private boolean checkLogin() {
        if(libraryNumber.equals("")) {
            System.out.println("Please log in.");
            return true;
        }
        return false;
    }

    public void returnBook(int bookId) {
        if (checkLogin()) return;
        for (Book book : bookList) {
            if (book.getId() == bookId) {
                if (book.isBooked()) {
                    if(!book.getUserName().equals(libraryNumber)) {
                        System.out.println("The book is not check by you!");
                    }
                    book.setUserName(null);
                    book.setBooked(false);
                    System.out.println("Thank you for returning the book.");
                } else {
                    System.out.println("That is not a valid book to return.");
                }
                break;
            }
        }
    }

    public void printMovieList() {
        System.out.println("Here is the list of the movies.");
        System.out.println(String.format("%-3s%-50s%-6s%-50s%-3s", "ID", "---MOVIE NAME---", "---YEAR---", "---DIRECTOR---", "---RATING---"));
        for (Movie movie : movieList) {
            if (!movie.isChecked()) {
                System.out.println(movie.toString());
            }
        }

    }

    public void initMovieList() {
        movieList.add(new Movie(1, "碟中谍6：全面瓦解", 2018, "克里斯托弗·麦奎里", 8.3, false));
        movieList.add(new Movie(2, "蚁人2：黄蜂女现身", 2018, "佩顿·里德", 7.5, false));
        movieList.add(new Movie(3, "苏丹", 2018, "阿里·阿巴斯·札法", 7.2, false));
        movieList.add(new Movie(4, "快把我哥带走", 2018, " 郑芬芬", 7.0, false));
        movieList.add(new Movie(5, "一出好戏", 2018, "黄渤", 7.3, false));
    }

    public void checkoutMovie(int movieId) {
        for (Movie movie : movieList) {
            if (movie.getId() == movieId) {
                if (movie.isChecked()) {
                    System.out.println("That movie is not available.");
                } else {
                    movie.setChecked(true);
                    System.out.println("Thank you! Enjoy the movie.");
                }
                break;
            }
        }
    }

    public boolean userLogin(String libraryNumber, String password) {
        if(userChecker.checkUser(libraryNumber, password)) {
            this.libraryNumber = libraryNumber;
        }
        return true;
    }
}
