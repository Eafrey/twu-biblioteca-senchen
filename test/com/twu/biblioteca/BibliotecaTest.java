package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

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
}
