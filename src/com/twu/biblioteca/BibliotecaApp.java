package com.twu.biblioteca;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static List<Book> bookList = new ArrayList();
    private static List<String> commandList = new ArrayList<>();

    public static void main(String[] args) {
        initBookList();
        printWelcomeMessage();
        listMenu();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.next();
            if (command.equals("q")) {
                break;
            }
            handlerInputMenuOption(command);
        }
    }

    static void handlerInputMenuOption(String command) {
        switch (command) {
            case "l":
                printBookList();
                break;
            case "c":
                System.out.println("input book id you want to checkout:");
                Scanner scanner = new Scanner(System.in);
                int bookId = scanner.nextInt();
                checkoutBook(bookId);
                break;
            default:
                System.out.println("Select a valid option!");
                break;
        }
    }

    static void printWelcomeMessage() {
        System.out.println("Welcome to Bangalore Public Library!");
    }

    static void printBookList() {
        System.out.println("Here is the list of the books.");
        System.out.println(String.format("%-3s%-50s%-50s%-50s", "ID", "---BOOK NAME---", "---AUTHOR---", "---PUBLISH DATE---"));
        for (Book book : bookList) {
            if (!book.isBooked) {
                System.out.println(book.toString());
            }
        }
    }

    static void initBookList() {
        bookList.add(new Book(1, "The Ragged Edge of Night", "Olivia Hawker", Instant.now(), false));
        bookList.add(new Book(2, "What Have You Done", "Matthew Farrell", Instant.now(), false));
        bookList.add(new Book(3, "We Were Mothers: A Novel", "Katie Sise", Instant.now(), false));
        bookList.add(new Book(4, "The Rule of One", "Ashley Saunders", Instant.now(), false));
        bookList.add(new Book(5, "You've Been So Lucky Already: A Memoir", "Alethea Black", Instant.now(), false));
    }

    static void listMenu() {
        System.out.println("---------------MENU---------------");
        System.out.println(String.format("%-15s -> press 'l'", "List Books"));
        System.out.println(String.format("%-15s -> press 'c'", "Checkout Book"));
        System.out.println(String.format("%-15s -> press 'r'", "Return Book"));
        System.out.println(String.format("%-15s -> press 'q'", "Quit"));
    }

    public static void checkoutBook(int bookId) {
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

    public void returnBook(int bookId) {
    }
}
