package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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

        User user = new User("123-4567", "password");

        library = new Library(Arrays.asList(bookOne, bookTwo), Arrays.asList(movieOne, movieTwo, movieThree), Arrays.asList(user));
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
        String userId = "123-4567";

        library.checkoutBook("Shawshank Redemption", userId);
        library.viewAvailableBooks();

        assertEquals(expected, outContent.toString());
    }

    @Test
    void shouldDisplayANotificationOnSuccessfulBookCheckout() {
        String expected = "Thank you! Enjoy the book\n";
        String userId = "123-4567";

        library.checkoutBook("Shawshank Redemption", userId);

        assertTrue(outContent.toString().contains(expected));
    }

    @Test
    void shouldDisplayUnSuccessfulMessageWhenBookIsNotAvailableForCheckout() {
        String expected = "Sorry, that book is not available\n";
        String userId = "123-4567";

        library.checkoutBook("Harry Potter", userId);

        assertTrue(outContent.toString().contains(expected));
    }

    @Test
    void shouldBeAbleToReturnABook() {
        String userId = "123-4567";
        String expected = "Thank you! Enjoy the book\n" +
                "Thank you for returning the book\n" +
                "Shawshank Redemption | Stephen King | 1982\n" +
                "Pride and Prejudice | Jane Austen | 1813\n";


        library.checkoutBook("Shawshank Redemption", userId);
        library.returnBook("Shawshank Redemption");
        library.viewAvailableBooks();

        assertEquals(expected, outContent.toString());
    }

    @Test
    void shouldDisplayNotificationOnSuccessfulReturnOfBook() {
        String userId = "123-4567";
        String expected = "Thank you! Enjoy the book\n" +
                "Thank you for returning the book\n";

        library.checkoutBook("Shawshank Redemption", userId);
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

    @Test
    void shouldBeAbleToCheckOutAnAvailableMovieFromLibrary() {
        String expected = "Thank you! Enjoy the movie\n";

        library.checkoutMovie("Titanic");

        assertEquals(expected, outContent.toString());
    }

    @Test
    void shouldNotBeAbleToCheckOutUnavailableMovieFromLibrary() {
        String expected = "Sorry, that movie is not available\n";

        library.checkoutMovie("Hello");

        assertEquals(expected, outContent.toString());
    }

    @Test
    void shouldCheckIfCheckedOutMovieIsNotAvailableInLibrary() {
        String expectedOutput = "Thank you! Enjoy the movie\n"
                + "Titanic | 1997 | James Cameron | 8\n" +
                "Jumanji | 1995 | Joe Johnston | 7\n";

        library.checkoutMovie("Joker");
        library.viewAvailableMovies();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void shouldBeAbleToValidateUserWhenNumberAndPasswordAreCorrect() {
        String number = "123-4567";
        String password = "password";
        assertTrue(library.validateUser(number, password));
    }

    @Test
    void shouldNotToValidateUserWhenNumberIsIncorrectFormat() {
        String number = "1234567";
        String password = "password";
        assertFalse(library.validateUser(number, password));
    }

    @Test
    void shouldNotToValidateUserWhenPasswordIsNotCaseSensitive() {
        String number = "123-4567";
        String password = "PassWord";
        assertFalse(library.validateUser(number, password));
    }

    @Test
    void shouldBeAbleToDisplayCheckedOutBooks() {
        String userId = "123-4567";
        String expected = "Thank you! Enjoy the book\n" +
                "Shawshank Redemption | Stephen King | 1982\n";
        library.checkoutBook("Shawshank Redemption", userId);
        library.viewCheckedoutBooks();

        assertEquals(expected, outContent.toString());
    }
}