package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

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
    void shouldCheckIfTwoBooksAreTheSame() { // TODO - equals not tested enough? Why? -DONE
        Book book = new Book("Harry Potter and The Sorcerer's Stone", "Rowling J.K.", "2001");
        Book expected = new Book("Harry Potter and The Sorcerer's Stone", "Rowling J.K.", "2001");

        assertEquals(expected, book); // TODO - at this point in time, just return true will work - DONE
    }

    @Test
    void shouldBeAbleToDisplayDetailsOfTheBook() {
        Book book = new Book("Harry Potter and The Sorcerer's Stone", "Rowling J.K.", "2001");
        String expected = "Harry Potter and The Sorcerer's Stone | Rowling J.K. | 2001";

        book.viewBookDetails();

        assertEquals(expected, outContent.toString().trim()); // TODO - why trim? So instead of fixing the actual or fixing the expected.... we ignored the problem? Apple flies up.
    }


}