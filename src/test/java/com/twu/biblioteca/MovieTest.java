package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

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
    void shouldBeAbleToViewMovieDetails() {
        Movie movie = new Movie("Titanic", "1997", "James Cameron", "8");
        String expectedOutput = "Titanic | 1997 | James Cameron | 8\n";

        movie.viewMovieDetails();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void shouldBeAbleToCompareTwoMoviesWithSameName() {
        Movie movie = new Movie("Titanic", "1997", "James Cameron", "8");

        assertTrue(movie.checkMovieByName("Titanic"));
    }

    @Test
    void shouldNotCompareTwoMoviesWithDifferentName() {
        Movie movie = new Movie("Titanic", "1997", "James Cameron", "8");

        assertFalse(movie.checkMovieByName("Hello"));
    }
}