package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

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
        Book bookOne = new Book("Wings of Fire");
        Book bookTwo = new Book("Runaway Jury");

        Library library = new Library(of(bookOne, bookTwo));
        String expected = "Wings of Fire\n" + "Runaway Jury";

        library.viewAvailableBooks();

        assertEquals(expected, outContent.toString().trim());
    }
}