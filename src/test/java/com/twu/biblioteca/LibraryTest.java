package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.ClientInfoStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void shouldBeAbleToCheckoutABookFromLibrary() {
        Library library = new Library();
        String expected = "Thank you! Enjoy the book\n" + "Pride and Prejudice | Jane Austen | 1813";

        library.checkoutBook("Shawshank Redemption");
        library.viewAvailableBooks();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldDisplayANotificationOnSuccessfulBookCheckout() {
        Library library = new Library();
        String expected = "Thank you! Enjoy the book";

        library.checkoutBook("Shawshank Redemption");

        assertTrue(outContent.toString().trim().contains(expected));
    }

    @Test
    void shouldDisplayUnSuccessfulMessageWhenBookIsNotAvailableForCheckout() {
        Library library = new Library();
        String expected = "Sorry, that book is not available";

        library.checkoutBook("Harry Potter");

        assertTrue(outContent.toString().trim().contains(expected));
    }

    @Test
    void shouldBeAbleToReturnABook() {
        Library library = new Library();
        String expected = "Thank you! Enjoy the book\n" +
                "Thank you for returning the book\n" +
                "Shawshank Redemption | Stephen King | 1982\n" +
                "Pride and Prejudice | Jane Austen | 1813";

        library.checkoutBook("Shawshank Redemption");
        library.returnBook("Shawshank Redemption");
        library.viewAvailableBooks();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldDisplayNotificationOnSuccessfulReturnOfBook() {
        Library library = new Library();
        String expected = "Thank you! Enjoy the book\n" +
                "Thank you for returning the book";

        library.checkoutBook("Shawshank Redemption");
        library.returnBook("Shawshank Redemption");

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void shouldDisplayWarningNotificationOnUnsuccessfulReturnOfBook() {
        Library library = new Library();
        String expected = "That is not a valid book to return";

        library.returnBook("abc");

        assertEquals(expected, outContent.toString().trim());
    }
}