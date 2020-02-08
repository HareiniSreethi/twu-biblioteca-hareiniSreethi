package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {

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
    void shouldBeAbleToDisplayNameOfBooksAvailable() {
        Library library = new Library();
        String expected = "Shawshank Redemption | Stephen King | 1982\n" +
        "Pride and Prejudice | Jane Austen | 1813";

        library.viewAvailableBooks();

        assertEquals(expected, outContent.toString().trim());
    }
}