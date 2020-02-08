package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BibliotecaAppTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
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

        assertEquals("1. List of Books", outContent.toString().trim());
    }

    @Test
    void shouldDisplayWelcomeMessageWithMenuOptionsToViewListOfBooksAfterSelection() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "1. List of Books\n" +
                "Shawshank Redemption | Stephen King | 1982\n" +
                "Pride and Prejudice | Jane Austen | 1813";

        bibliotecaApp.displayWelcomeMessage();
        bibliotecaApp.displayMenuOptions();
        bibliotecaApp.selectOption(1);

        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    void shouldDisplayNotificationWhenInvalidOptionIsSelected() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "1. List of Books\n" +
                "Please select a valid option!";

        bibliotecaApp.displayWelcomeMessage();
        bibliotecaApp.displayMenuOptions();
        bibliotecaApp.selectOption(2);

        assertEquals(expectedOutput, outContent.toString().trim());
    }
}