package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BibliotecaAppTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private InputStream originalIn;


    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        originalIn = System.in;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void shouldDisplayWelcomeMessageWhenApplicationStarts() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayWelcomeMessage();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", outContent.toString().trim());
    }

    @Test
    void shouldDisplayListOfAvailableBooksAfterWelcomeMessage() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "Shawshank Redemption | Stephen King | 1982\n" +
                "Pride and Prejudice | Jane Austen | 1813";

        bibliotecaApp.displayWelcomeMessage();
        bibliotecaApp.displayAvailableBooks();

        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    void shouldDisplayMenuOptionsToViewListOfBooks() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.displayMenuOptions();

        assertEquals("1. List of Books\n" + "2. Quit", outContent.toString().trim());
    }

    @Test
    void shouldDisplayMenuOptionsToViewListOfBooksAfterSelection() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String option = "1";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        String expectedOutput = "Shawshank Redemption | Stephen King | 1982\n" +
                "Pride and Prejudice | Jane Austen | 1813";

        bibliotecaApp.displayWelcomeMessage();
        bibliotecaApp.displayMenuOptions();
        bibliotecaApp.selectOption();

        assertTrue(outContent.toString().trim().contains(expectedOutput));
    }

    @Test
    void shouldDisplayNotificationWhenInvalidOptionIsSelected() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String option = "2";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        String expectedOutput = "Please select a valid option!";

        bibliotecaApp.displayWelcomeMessage();
        bibliotecaApp.displayMenuOptions();
        bibliotecaApp.selectOption();

        assertTrue(outContent.toString().trim().contains(expectedOutput));
    }
}