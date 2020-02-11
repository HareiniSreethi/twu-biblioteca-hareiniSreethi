package com.twu.biblioteca;

import com.twu.biblioteca.MenuStrategy.Strategy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO - can use some namespacing - packages
class BibliotecaAppTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private BibliotecaApp bibliotecaApp;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Book bookOne = new Book("Shawshank Redemption", "Stephen King", "1982");
        Book bookTwo = new Book("Pride and Prejudice", "Jane Austen", "1813");
        Library library = new Library(Arrays.asList(bookOne, bookTwo));
        UserInput userInput = new UserInput(new Strategy(library));
        Menu menu = new Menu();
        bibliotecaApp = new BibliotecaApp(userInput, library, menu);
    }


    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void shouldDisplayWelcomeMessageWhenApplicationStarts() {
        bibliotecaApp.displayWelcomeMessage();

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n", outContent.toString());
    }

    @Test
    void shouldDisplayListOfAvailableBooksAfterWelcomeMessage() {
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "Shawshank Redemption | Stephen King | 1982\n" +
                "Pride and Prejudice | Jane Austen | 1813\n";

        bibliotecaApp.displayWelcomeMessage();
        bibliotecaApp.displayAvailableBooks();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void shouldDisplayMenuOptionsToViewListOfBooks() {
        bibliotecaApp.displayMenuOptions();

        assertEquals("1. List of Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. List of Movies\n" +
                "5. Quit\n", outContent.toString());
    }

    @Test
    void shouldDisplayMenuOptionsToViewListOfBooksAfterSelection() {
        String option = "1";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        String expectedOutput = "Shawshank Redemption | Stephen King | 1982\n" +
                "Pride and Prejudice | Jane Austen | 1813\n";

        bibliotecaApp.displayWelcomeMessage();
        bibliotecaApp.displayMenuOptions();
        bibliotecaApp.selectOption();

        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    void shouldDisplayNotificationWhenInvalidOptionIsSelected() {
        String option = "8";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        String expectedOutput = "Please select a valid option!\n";

        bibliotecaApp.displayWelcomeMessage();
        bibliotecaApp.displayMenuOptions();
        bibliotecaApp.selectOption();

        assertTrue(outContent.toString().contains(expectedOutput));
    }

}