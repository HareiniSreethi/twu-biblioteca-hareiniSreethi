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

class UserInputTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private UserInput userInput;

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

        Library library = new Library(Arrays.asList(bookOne, bookTwo), Arrays.asList(movieOne, movieTwo, movieThree));
        userInput = new UserInput(new Strategy(library));
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
                "Pride and Prejudice | Jane Austen | 1813\n";

        userInput.selectMenuOption();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void shouldDisplayNotificationWhenInvalidOptionIsSelected() {
        String option = "8";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        String expectedOutput = "Please select a valid option!\n";

        userInput.selectMenuOption();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void shouldBeAbleToCheckOutABook() {
        String option = "2\nPride and Prejudice";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        String expectedOutput = "Enter book name to check out : \n" +
                "Thank you! Enjoy the book\n";

        userInput.selectMenuOption();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void shouldNotifyOnUnsuccessfulCheckoutOfABook() {
        String option = "2\nHello";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        String expectedOutput = "Enter book name to check out : \n" +
                "Sorry, that book is not available\n";

        userInput.selectMenuOption();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void shouldBeAbleToNotifyOnSuccessfulReturnOfCheckedOutBook() {
        String option = "3\nPride and Prejudice";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        String expectedOutput = "Enter book name to return : \n" +
                "That is not a valid book to return\n";

        userInput.selectMenuOption();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void shouldDisplayAvailableMoviesOnOptionFourSelection() {
        String option = "4";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        String expectedOutput = "Titanic | 1997 | James Cameron | 8\n" +
                "Joker | 2019 | Todd Phillips | 9\n" +
                "Jumanji | 1995 | Joe Johnston | 7\n";

        userInput.selectMenuOption();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void shouldBeAbleToCheckOutMovieAndReceiveSuccessfulNotification() {
        String option = "5\nJoker";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        String expectedOutput = "Enter book name to check out : \n" +
                "Thank you! Enjoy the movie\n";

        userInput.selectMenuOption();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void shouldNotBeAbleToCheckOutUnAvailableMovie() {
        String option = "5\nRadio";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        String expectedOutput = "Enter book name to check out : \n" +
                "Sorry, that movie is not available\n";

        userInput.selectMenuOption();

        assertEquals(expectedOutput, outContent.toString());
    }

}