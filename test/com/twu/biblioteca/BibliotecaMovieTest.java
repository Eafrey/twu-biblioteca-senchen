package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BibliotecaMovieTest {
    BibliotecaApp bibliotecaApp;
    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void construcBibliotecaApp() {
        System.setOut(new PrintStream(outputContent));

        bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.initMovieList();
    }

    @Test
    public void shouldListMovies() {
        bibliotecaApp.printMovieList();
        assertThat(outputContent.toString(), containsString("MOVIE NAME"));
        assertThat(outputContent.toString(), containsString("YEAR"));
        assertThat(outputContent.toString(), containsString("DIRECTOR"));
        assertThat(outputContent.toString(), containsString("RATING"));
    }

    @Test
    public void shouldCorrectlyCheckMovie() {
        bibliotecaApp.checkoutMovie(2);
        bibliotecaApp.printMovieList();
        assertTrue(outputContent.toString().contains("Thank you! Enjoy the movie."));
        assertFalse(outputContent.toString().contains("蚁人2：黄蜂女现身"));
    }

    @Test
    public void shouldGetPromptUnscuccesCheckMovie() {
        bibliotecaApp.checkoutMovie(2);
        bibliotecaApp.checkoutMovie(2);
        bibliotecaApp.printMovieList();
        assertTrue(outputContent.toString().contains("That movie is not available."));
    }

}
