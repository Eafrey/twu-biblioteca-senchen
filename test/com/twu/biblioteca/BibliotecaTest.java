package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {

    BibliotecaApp bibliotecaApp;
    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void construcBibliotecaApp() {
        bibliotecaApp = new BibliotecaApp();
        System.setOut(new PrintStream(outputContent));
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

}
