package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInputTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private InputStream originalIn;
    private Library library;
    private UserInput userInput;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalIn = System.in;
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        Book bookOne = new Book("Shawshank Redemption", "Stephen King", "1982");
        Book bookTwo = new Book("Pride and Prejudice", "Jane Austen", "1813");
        library = new Library(Arrays.asList(bookOne, bookTwo));
        userInput = new UserInput(library);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void shouldDisplayAvailableBooksOnOptionOne() {
        String option = "1";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        String expectedOutput = "Shawshank Redemption | Stephen King | 1982\n" +
                "Pride and Prejudice | Jane Austen | 1813";

        userInput.getOption();

        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    void shouldDisplayNotificationWhenInvalidOptionIsSelected() {
        String option = "8";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        String expectedOutput = "Please select a valid option!";

        userInput.getOption();

        assertEquals(expectedOutput, outContent.toString().trim());
    }
}