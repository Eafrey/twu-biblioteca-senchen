package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BibliotecaTest {

    BibliotecaApp bibliotecaApp;
    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void construcBibliotecaApp() {
        System.setOut(new PrintStream(outputContent));

        bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.initBookList();
    }

    @Test
    public void shouldHaveWelcomeMessage() {
        bibliotecaApp.printWelcomeMessage();
        assertEquals("Welcome to Bangalore Public Library!\n", outputContent.toString());
    }

    @Test
    public void shouldListBooks() {
        bibliotecaApp.printBookList();
        assertThat(outputContent.toString(), containsString("BOOK NAME"));
        assertThat(outputContent.toString(), containsString("AUTHOR"));
        assertThat(outputContent.toString(), containsString("PUBLISH DATE"));
    }

    @Test
    public void shouldListMenu() {
        bibliotecaApp.listMenu();
        assertThat(outputContent.toString(), containsString("MENU"));
        assertThat(outputContent.toString(), containsString("List Books"));
        assertThat(outputContent.toString(), containsString("Quit"));
    }

    @Test
    public void shouldBeNotifiedWhenChooseInvalidMenuOption() {
        bibliotecaApp.handlerInputMenuOption("w");
        assertThat(outputContent.toString(), containsString("Select a valid option!"));
    }

    @Test
    public void shouldCorrectlyCheckBook() {
        bibliotecaApp.checkoutBook(2);
        bibliotecaApp.printBookList();
        assertTrue(outputContent.toString().contains("Thank you! Enjoy the book."));
        assertFalse(outputContent.toString().contains("What Have You Done"));
    }

    @Test
    public void shouldGetPromptUnscuccesCheckBook() {
        bibliotecaApp.checkoutBook(2);
        bibliotecaApp.checkoutBook(2);
        bibliotecaApp.printBookList();
        assertTrue(outputContent.toString().contains("That book is not available."));
        bibliotecaApp.returnBook(2);
    }

    @Test
    public void shouldCorrectlyReturnBook() {
        bibliotecaApp.checkoutBook(2);
        bibliotecaApp.returnBook(2);
        bibliotecaApp.printBookList();
        assertTrue(outputContent.toString().contains("Thank you for returning the book."));
        assertTrue(outputContent.toString().contains("What Have You Done"));
    }

    @Test
    public void shouldGetPromptUnscuccesReturnBook() {
        bibliotecaApp.returnBook(2);
        assertThat(outputContent.toString(),is("That is not a valid book to return.\n"));
    }

}
