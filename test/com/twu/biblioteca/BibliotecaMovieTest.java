package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class BibliotecaMovieTest {
    BibliotecaApp bibliotecaApp;
    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void construcBibliotecaApp() {
        System.setOut(new PrintStream(outputContent));

        bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.initBookList();
    }

    @Test
    public void shouldListMovies() {
        bibliotecaApp.printMovies();
        assertThat(outputContent.toString(), containsString("MOVIE NAME"));
        assertThat(outputContent.toString(), containsString("YEAR"));
        assertThat(outputContent.toString(), containsString("DIRECTOR"));
        assertThat(outputContent.toString(), containsString("MOVIE RATING"));
    }
}
