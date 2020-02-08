package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInputTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private InputStream originalIn;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalIn = System.in;
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void shouldDisplayAvailableBooksOnOptionOne() {
        String option = "1";
        System.setIn(new ByteArrayInputStream(option.getBytes()));
        UserInput userInput = new UserInput();
        String expectedOutput = "Shawshank Redemption | Stephen King | 1982\n" +
                "Pride and Prejudice | Jane Austen | 1813";

        userInput.getOption();

        assertEquals(expectedOutput, outContent.toString().trim());
    }
}