package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private Library library;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Book bookOne = new Book("Shawshank Redemption", "Stephen King", "1982");
        Book bookTwo = new Book("Pride and Prejudice", "Jane Austen", "1813");

        Movie movieOne = new Movie("Titanic", "1997", "James Cameron", "8");
        Movie movieTwo = new Movie("Joker", "2019", "Todd Phillips", "9");
        Movie movieThree = new Movie("Jumanji", "1995", "Joe Johnston", "7");

        library = new Library(Arrays.asList(bookOne, bookTwo), Arrays.asList(movieOne, movieTwo, movieThree));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void shouldBeAbleToDisplayNameOfBooksAvailable() {
        String expected = "Shawshank Redemption | Stephen King | 1982\n" +
                "Pride and Prejudice | Jane Austen | 1813\n"; // TODO - how do I know that this is expected? Why is this expected?

        library.viewAvailableBooks();

        assertEquals(expected, outContent.toString());
    }

    @Test
    void shouldBeAbleToCheckoutABookFromLibrary() {
        String expected = "Thank you! Enjoy the book\n" + "Pride and Prejudice | Jane Austen | 1813\n";

        library.checkoutBook("Shawshank Redemption");
        library.viewAvailableBooks();

        assertEquals(expected, outContent.toString());
    }

    @Test
    void shouldDisplayANotificationOnSuccessfulBookCheckout() {
        String expected = "Thank you! Enjoy the book\n";

        library.checkoutBook("Shawshank Redemption");

        assertTrue(outContent.toString().contains(expected));
    }

    @Test
    void shouldDisplayUnSuccessfulMessageWhenBookIsNotAvailableForCheckout() {
        String expected = "Sorry, that book is not available\n";

        library.checkoutBook("Harry Potter");

        assertTrue(outContent.toString().contains(expected));
    }

    @Test
    void shouldBeAbleToReturnABook() {
        String expected = "Thank you! Enjoy the book\n" +
                "Thank you for returning the book\n" +
                "Shawshank Redemption | Stephen King | 1982\n" +
                "Pride and Prejudice | Jane Austen | 1813\n";

        library.checkoutBook("Shawshank Redemption");
        library.returnBook("Shawshank Redemption");
        library.viewAvailableBooks();

        assertEquals(expected, outContent.toString());
    }

    @Test
    void shouldDisplayNotificationOnSuccessfulReturnOfBook() {
        String expected = "Thank you! Enjoy the book\n" +
                "Thank you for returning the book\n";

        library.checkoutBook("Shawshank Redemption");
        library.returnBook("Shawshank Redemption");

        assertEquals(expected, outContent.toString());
    }

    @Test
    void shouldDisplayWarningNotificationOnUnsuccessfulReturnOfBook() {
        String expected = "That is not a valid book to return\n";

        library.returnBook("abc");

        assertEquals(expected, outContent.toString());
    }

    @Test
    void shouldBeAbleToViewListOfAvailableMovies() {
        String expectedOutput = "Titanic | 1997 | James Cameron | 8\n" +
                "Joker | 2019 | Todd Phillips | 9\n" +
                "Jumanji | 1995 | Joe Johnston | 7\n";

        library.viewAvailableMovies();

        assertEquals(expectedOutput, outContent.toString());
    }
}