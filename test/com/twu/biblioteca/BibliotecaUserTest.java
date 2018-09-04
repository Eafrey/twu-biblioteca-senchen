package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibliotecaUserTest {

    BibliotecaApp bibliotecaApp;
    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void construcBibliotecaApp() {
        System.setOut(new PrintStream(outputContent));

        bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.initMovieList();
    }


    @Test
    public void bookShouldChckedWithUserName() {
        bibliotecaApp.userLogin("1111-1111", "123456");
        bibliotecaApp.checkoutBook(2);
        bibliotecaApp.bookList.get(1).getUserName().equals("1111-1111");
    }

}
