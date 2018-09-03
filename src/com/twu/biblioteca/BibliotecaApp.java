package com.twu.biblioteca;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private  List<Book> bookList = new ArrayList();
    private  List<String> commandList = new ArrayList<>();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.initBookList();
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
            case "l":
                printBookList();
                break;
            case "c":
                System.out.println("input book id you want to checkout:");
                int checkoutBookId = scanner.nextInt();
                checkoutBook(checkoutBookId);
                break;
            case "r":
                System.out.println("input book id you want to return:");
                int returnBookId = scanner.nextInt();
                returnBook(returnBookId);
                break;
            default:
                System.out.println("Select a valid option!");
                break;
        }
    }

     void printWelcomeMessage() {
        System.out.println("Welcome to Bangalore Public Library!");
    }

     void printBookList() {
        System.out.println("Here is the list of the books.");
        System.out.println(String.format("%-3s%-50s%-50s%-50s", "ID", "---BOOK NAME---", "---AUTHOR---", "---PUBLISH DATE---"));
        for (Book book : bookList) {
            if (!book.isBooked) {
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
        System.out.println(String.format("%-15s -> press 'l'", "List Books"));
        System.out.println(String.format("%-15s -> press 'c'", "Checkout Book"));
        System.out.println(String.format("%-15s -> press 'r'", "Return Book"));
        System.out.println(String.format("%-15s -> press 'q'", "Quit"));
    }

    public  void checkoutBook(int bookId) {
        for (Book book : bookList) {
            if (book.getId() == bookId) {
                if (book.isBooked) {
                    System.out.println("That book is not available.");
                } else {
                    book.setBooked(true);
                    System.out.println("Thank you! Enjoy the book.");
                }
                break;
            }
        }
    }

    public  void returnBook(int bookId) {
        for (Book book : bookList) {
            if (book.getId() == bookId) {
                if (book.isBooked) {
                    book.setBooked(false);
                    System.out.println("Thank you for returning the book.");
                } else {
                    System.out.println("That is not a valid book to return.");
                }
                break;
            }
        }
    }
}
