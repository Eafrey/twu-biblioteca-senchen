package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {

    BibliotecaApp bibliotecaApp;

    @Before
    public void construcBibliotecaApp() {
        bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void shouldHaveWelcomeMessage() {
        final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        bibliotecaApp.printWelcomeMessage();
        assertEquals("Welcome to Bangalore Public Library!\n", outputContent.toString());
    }

    @Test
    public void shouldListBooks() {
        final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
        bibliotecaApp.printBookList();
        assertThat(outputContent.toString(), containsString("BOOK NAME"));
        assertThat(outputContent.toString(), containsString("AUTHOR"));
        assertThat(outputContent.toString(), containsString("PUBLISH DATE"));
    }
}
