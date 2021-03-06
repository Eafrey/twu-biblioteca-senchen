package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BibliotecaPresetUsersTest {

    BibliotecaApp bibliotecaApp;
    final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @Before
    public void construcBibliotecaApp() {
        System.setOut(new PrintStream(outputContent));

        bibliotecaApp = new BibliotecaApp();
    }


    @Test
    public void bookShouldChckedWithUserName() {
        bibliotecaApp.userLogin("1111-1111", "123456");
        bibliotecaApp.checkoutBook(2);
        assertThat(bibliotecaApp.bookList.get(1).getUserName(), is("1111-1111"));
    }

    @Test
    public void shouldShowUserInfo() {
        bibliotecaApp.userLogin("1111-1111", "123456");
        bibliotecaApp.showUserInfo();
        assertThat(outputContent.toString(), containsString("1111-1111"));
        assertThat(outputContent.toString(), containsString("1@tw.com"));
        assertThat(outputContent.toString(), containsString("18812345678"));
    }

}
